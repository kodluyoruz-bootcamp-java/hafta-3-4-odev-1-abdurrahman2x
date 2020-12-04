package com.abdurrahman;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.function.BiFunction;


public  class City implements Clock,Comparable< City> {
    private final String GMT;
    private final String name;
    private final String cityCode;

    public City(String name,String cityCode,String GMT){
        this.name = name;
        this.cityCode = cityCode;
        this.GMT = GMT;
    }

    public String getGMT(){
        return this.GMT;
    }
    public String getCityCode(){
        return this.cityCode;
    }
    public String getName(){
        return this.name;
    }



    @Override
    public void showTime() {
        SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss ");
        Date date = new Date();
        sd.setTimeZone(TimeZone.getTimeZone(this.GMT));
        System.out.printf("%15s  : %s\n",this.name,sd.format(date));
    }

    @Override
    public int compareTo(City o) {
        int compareInt = this.name.compareTo(o.getName());
        if (compareInt < 0) return  -1;
        else if (compareInt > 0) return 1;
        else return 0;
    }
    public boolean compareCode(String cityCode){
        return this.cityCode.equals(cityCode);
    }

}
