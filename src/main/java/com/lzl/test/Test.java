package com.lzl.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.UUID;
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
        System.out.println(UUID.randomUUID());
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