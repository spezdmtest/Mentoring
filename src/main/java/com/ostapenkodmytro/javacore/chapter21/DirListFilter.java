package com.ostapenkodmytro.javacore.chapter21;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirListFilter {
    public static void main(String[] args) {
        String dirname = "C:\\Users\\spezdm\\IdeaProjects\\Mentoring\\src\\main\\java";
        DirectoryStream.Filter<Path> how = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path filename) {
                return Files.isWritable(filename);
            }
        };
        try (DirectoryStream<Path> dirstrm =
                     Files.newDirectoryStream(Path.of(dirname), how)) {
            System.out.println("Каталог " + dirname);

            for (Path entry : dirstrm) {
                BasicFileAttributes attribs = Files.readAttributes(entry, BasicFileAttributes.class);

                if (attribs.isDirectory())
                    System.out.print("<DIR> ");
                else
                    System.out.print("     ");
                System.out.println(entry.getFileName());
            }
        } catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути " + e);
        } catch (NotDirectoryException e) {
            System.out.println(dirname + " не является каталогом.");
        } catch (IOException e) {
            System.out.println("Ошибка ввода вывода: " + e);
        }
    }
}