package com.study.thread;

/**
 * @author 王贤
 */
public class ThreadTest {

    public static final int DELAY = 10 ;
    public static final int STEPS=100;
    public static final double MAX_AMOUNT = 1000;

    public static void main(String[] args) {

        var bank = new Bank(4,100000);
        Runnable r = () -> {
            try {
                for (int i =0;i<STEPS;i++){
                    double amount = MAX_AMOUNT *Math.random();
                    bank.transfer(0,1,amount);
                    Thread.sleep((int) (DELAY*Math.random()));
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        };
        Runnable r2 = () -> {
            try {
                for (int i =0;i<STEPS;i++){
                    double amount = MAX_AMOUNT *Math.random();
                    bank.transfer(2,3,amount);
                    Thread.sleep((int) (DELAY*Math.random()));
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        };
        new Thread(r).start();
        new Thread(r2).start();
        final Thread thread = new Thread(r);
        thread.setDaemon(true);
        thread.start();


    }
}
