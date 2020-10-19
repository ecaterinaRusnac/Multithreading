package com.company;

import java.util.Random;

class Egg extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            try {
                // "Pause" thread
                sleep(ChickenEgg.getTimeSleep());
                System.out.println("Egg");
            } catch(InterruptedException e){}
        }
    }
}

public class ChickenEgg {
    public static int getTimeSleep() {
        final Random random = new Random();
        int tm = random.nextInt(1000);
        if (tm < 10)
            tm *= 100;
        else if (tm < 100)
            tm *= 10;
        return tm;
    }

    public static void main(String[] args) {
        Egg egg = new Egg (); // create thread
        System.out.println("Start discussion : who was first?");

        egg.start(); // start thread
        for(int i = 0; i < 5; i++) {
            try {
                // "Pause" thread
                Thread.sleep(ChickenEgg.getTimeSleep());
                System.out.println("Chicken");
            } catch(InterruptedException e){}
        }
        if(egg.isAlive()) {
            try {
                // Wait till egg finish to speak out
                egg.join();
            } catch (InterruptedException e){}

            System.out.println("Egg appeared first!!!");
        } else {
            //if the opponent has already finished speaking
            System.out.println("Chicken appeared first!!!");
        }
        System.out.println("Discussion finished!");
    }
}
