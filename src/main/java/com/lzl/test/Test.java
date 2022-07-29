package com.lzl.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.zip.ZipOutputStream;

/**
 * @Description
 * @Author LZL
 * @Date 2021.09.01-19:56
 */
public class Test {
    //    private static Test t=new Test();
////    private static Test t1=new Test();
    static {
        System.out.println("静态块");
    }

    {
        System.out.println("构造块");
    }

    {
        System.out.println("构造快1");
    }

    public Test() {
        System.out.println("构造方法");
    }

    public static void main(String[] args) throws FileNotFoundException {
        ZipOutputStream zip = new ZipOutputStream(new FileOutputStream("D:\\"));
//        Test t=new Test();
//        T tw=new T();
        String s = new String("2222");
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");

        System.out.println(str5.equals(str3));
        System.out.println(str5 == str3);
        System.out.println(str5.intern() == str3);
        System.out.println(str5.intern() == str4);
        System.out.println();
        System.out.println();
        System.out.println();


        String a = "abc";
        String b = "abc";
        String c = "a" + "b" + "c";
        String d = "a" + "bc";
        String e = "ab" + "c";

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);
        System.out.println(a == e);
        System.out.println(c == d);
        System.out.println(c == e);
    }
}

class T extends Test {
    static {
        System.out.println("子类静态");
    }

    {
        System.out.println("子类代码");
    }

    public T() {
        System.out.println("在构造");
    }
}