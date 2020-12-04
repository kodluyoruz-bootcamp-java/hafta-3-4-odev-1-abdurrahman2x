package com.abdurrahman;

import static java.lang.Thread.*;

public class TimeRunnable implements Runnable{
    private City city;
    private int SN = 1000;
    public TimeRunnable(City city){
        this.city = city;
    }
    @Override
    public void run() {
        try {
            sleep(SN);
            synchronized (this){
                this.city.showTime();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }





    }
}
