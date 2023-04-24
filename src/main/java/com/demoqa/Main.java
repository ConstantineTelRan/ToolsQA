package com.demoqa;

public class Main {
    public static void main(String[] args) {
        int b = sum();
        String a = "kdkdkdkde";
        String c = " jdjdjdjdjd";
        String t = text(a, c);
        System.out.println(b);
        System.out.println(t);
        sum2();
//        System.out.println(sum2());

    }

    public static int sum() {
        int x = 2;
        int y = 3;
        int z = x + y;
        return z;
    }

    public boolean f() {
        return true;
    }



    public static String text(String w, String r) {
        return w + r;
    }

    public static void sum2() {
        int x = 2;
        int y = 3;
        int z = x + y;
    }
}