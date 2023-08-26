package com.ostapenkodmytro.javacore.chapter10.Example;

//public class App {
//    public static void main(String[] args) {
//        System.out.println("sout");
//        throw new Error();
//    }
//}

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
public class App {
//    public static void main(String[] args) {
//        sqr(10);
//    }

    //    public static double sqr(double arg) {
//        while (true); // Удивительно, но КОМПИЛИРУЕТСЯ!
//    }
//public static double sqr(double arg) {
//    if (System.currentTimeMillis() % 2 == 0) {
//        return arg * arg; // ну ладно, вот твой double
//    } else {
//        while (true);     // а тут "виснем" навсегда
//    }
//}
//    public static double sqr(double arg) {// согласно объявлению метода ты должен вернуть double
//        long time = System.currentTimeMillis();
//        if (time % 2 == 0) {
//            return arg * arg;             // ок, вот твой double
//        } else if (time % 2 == 1) {{
//                while (true) ;                 // не, я решил "повиснуть"
//            } else {
//                throw new RuntimeException(); // или бросить исключение
//            }
//        }
//    }

//    public static void main(String[] args) {
//        // sqr - "сломается" (из него "выскочит" исключение),
//        double d = sqr(10.0);  // выполнение метода main() прервется в этой строчке и
//        // d - НИКОГДА НИЧЕГО НЕ БУДЕТ ПРИСВОЕНО!
//        System.out.println(d); // и печатать нам ничего не придется!
//    }
//    public static double sqr(double arg) {
//        throw new RuntimeException(); // "бросаем" исключение
//    }

    //
//    public static void main(String[] args) {
//        try {
//            System.err.print(" 0");
//            if (true) {
//                throw new RuntimeException();
//            }
//            System.err.print(" 1");
//        } catch (Exception e) { // catch по Exception ПЕРЕХВАТЫВАЕТ RuntimeException
//            System.err.print(" 2");
//        }
//        System.err.println(" 3");
//    }

//

//    public static void main(String[] args) {
//        try {
//            System.exit(42);
//        } finally {
//            System.err.println("finally");
//        }
//    }

//    public static void main(String[] args) {
//        try {
//            Runtime.getRuntime().halt(42);
//        } finally {
//            System.err.println("finally");
//        }
//    }

    //
//    public static void main(String[] args) throws Exception {
//        Throwable t = new Exception(); // и лететь будет Exception
//        throw t; // но тут ошибка компиляции
//    }
//    public static void main(String[] args) throws Exception {
//        Object ref = "Hello!";  // ref указывает на строку
//        char c = ref.charAt(0); // но тут ошибка компиляции
//    }
//    public static void f0(Throwable t) throws Exception {
//        throw t;
//    }
//    public static void f1(Object ref){
//        char c = ref.charAt(0);
//    }

//    public static void main(String[] args) throws Exception {
//        try {
//            Throwable t = new Exception(); // и лететь будет Exception
//            throw t; // но тут ошибка компиляции
//        } catch (Exception e) {
//            System.out.println("Перехвачено!");
//        }
//    }

//    public static void main(String[] args) throws Throwable {
//        try {
//            Throwable t = new Exception(); // а лететь будет Exception
//            throw t;
//        } catch (Exception e) { // и мы перехватим Exception
//            System.out.println("Перехвачено!");
//        }
//    }
 */

//public class Parent {
//    // предок пугает IOException и InterruptedException
//    public void f() throws Exception , InterruptedException {}
//}
//
//class Child extends Parent {
//    // а потомок пугает только потомком IOException
//    @Override
//    public void f() throws IOException {}
//}