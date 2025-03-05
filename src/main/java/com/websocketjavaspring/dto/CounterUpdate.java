package com.websocketjavaspring.dto;


public class CounterUpdate {
    private static int counter = 0;
    private int counterValue;
    public CounterUpdate(boolean increment) {
        if(increment) {
            counter++;
        }
        this.counterValue = counter;
    }

    public  int getCounter() {
        return counterValue;
    }

    public static void setCounter(int counter) {
        CounterUpdate.counter = counter;
    }

    public void testFuncForLab(){
        int a = 0;
    }
    
}