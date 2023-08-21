package com.ostapenkodmytro.javacore.chapter20;

import java.io.File;
import java.io.FilenameFilter;

public class DirListOnly {
    public static void main(String[] args) {
        String dirname = "C:/Users/spezdm/IdeaProjects/Mentoring/src/main/java/";
        File f1 = new File(dirname);
        FilenameFilter only = new OnlyExt("html");
        String[] s = f1.list(only);

        assert s != null;
        for (String value : s) {
            System.out.println(value);
        }
    }
}