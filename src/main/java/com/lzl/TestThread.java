package com.lzl;

/**
 * 测试线程
 *
 * @author LZL
 * @date 2022/12/19-16:31
 */
public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        int c=0;
        while (true) {
            c++;
            if(c>5){
                c=6;
                continue;
            }
            for (int i = 0; i < 5; i++) {
                Thread t = new Thread(new HelloT());
                t.start();
            }
        }
    }
    static class HelloT implements Runnable {

        @Override
        public void run() {
           while (true) {
               try {
                   Thread.sleep(10000);
                   System.out.println("我是子线程");
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }
    }
}