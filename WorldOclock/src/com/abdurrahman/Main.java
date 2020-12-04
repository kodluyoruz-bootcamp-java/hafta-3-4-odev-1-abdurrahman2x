package com.abdurrahman;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
   public static void main(String[] args) {
       MyKeyListener keyboard = new MyKeyListener();
       JFrame frame = new JFrame();
       frame.setTitle("Java key listener to exit");
      // frame.setSize(400, 200);
       frame.setResizable(false);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.addKeyListener(keyboard);
       frame.setVisible(true);
            Scanner scanner = new Scanner(System.in);
           ArrayList<City> cityArrayList = new ArrayList<>();
            cityArrayList.add(new City("Moscow","MOW","GMT+3"));
            cityArrayList.add(new City("Berlin","BER","GMT+1"));
            cityArrayList.add(new City("London","LON","GMT"));
            cityArrayList.add(new City("New Delhi","DEL","GMT+5.5"));
            cityArrayList.add(new City("Newyork","NYC","GMT-5"));
            Collections.sort(cityArrayList);
            Map<String,City> citiesMap = new HashMap<String,City>();
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            for (int i = 0;i<cityArrayList.size();i++){
                citiesMap.put(cityArrayList.get(i).getCityCode(),cityArrayList.get(i));
            }
       for (int i = 0;i < cityArrayList.size();i++) {
           System.out.println("City Code: "+cityArrayList.get(i).getCityCode()+" City name: "+cityArrayList.get(i).getName());
       }
       System.out.println("Şehir saatlerini görebilmek için lütfen listede olan en az 3 en fazla 5 şehir kodu giriniz");


   try {
           while (true) {
               boolean legal = true;
               String codes = scanner.nextLine();
               String[] cityCodes = codes.split(" ");
               for (String s: cityCodes) {
                   if (s.length() >= 4){
                       legal = false;
                   }
               }
               if (cityCodes.length < 3 || cityCodes.length > 5 || legal == false) {
                   System.out.println("Hatalı kod girişi yaptınız,\nLütfen en az 3 en fazla 5 şehir kodu giriniz: ");
               }
               else {
                   int count = 0;
                   for (int i = 0; i < cityCodes.length; i++) {
                       if (citiesMap.containsKey(cityCodes[i])){
                           count++;
                       }
                   }
                   if (count == cityCodes.length){
                       while (true) {
                           for (int i = 0; i < cityCodes.length; i++) {
                               Thread.sleep(500);
                               executorService.execute(new TimeRunnable(citiesMap.get(cityCodes[i])));
                           }
                       }
                   }
               }
           }
       }
       catch (Exception e){
           System.out.println("Hatalı veri girişi yaptınız.");
       }










        }
}
