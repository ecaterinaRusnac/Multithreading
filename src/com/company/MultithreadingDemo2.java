package com.company;

public class MultithreadingDemo2 implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
            System.out.println("Thread " + Thread.currentThread().getName() + " is running");
            Thread.currentThread().setName("My name");
//            Thread.currentThread().setPriority(5);
            System.out.println("Thread " + Thread.currentThread().getPriority() + " is running");
        } catch (Exception e) {
            System.out.println("Exception is caught");
        }
    }

    public static void main(String[] args) {
        int n = 2;
        for (int i = 0; i < n; i++) {
            MultithreadingDemo obj = new MultithreadingDemo();
            obj.start();
        }
    }
}
