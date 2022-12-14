package com.shapovalov.course.service;

import com.shapovalov.course.model.Advertisement;

import java.util.ArrayList;

public class BriefDescriptionCreator {

    public static String[] getBriefDescriptions(Iterable<Advertisement> advertisements) {
        String advertDescription;
        ArrayList<String []> listOfArraysWithWords = new ArrayList<>();
        String [] arrayWithWords;
        int advertsNumber = 0;

        for (Advertisement adv : advertisements) {
            advertDescription = adv.getDescription();
            arrayWithWords = advertDescription.split(" ");
            listOfArraysWithWords.add(arrayWithWords);
            advertsNumber++;
        }


        ArrayList<ArrayList<String>> superList =
                new ArrayList<ArrayList<String>>();

        for (int i = 0; i <advertsNumber; i++) {
            superList.add(new ArrayList<>());
            for (int j = 0; j <listOfArraysWithWords.get(i).length; j++) {
                superList.get(i).add(listOfArraysWithWords.get(i)[j]);
            }
        }

        for (int i = 0; i < superList.size(); i++) {
            while (superList.get(i).size()>40) {
                superList.get(i).remove(40);
            }
        }

        String [] arr = new String[advertsNumber];
        for (int i = 0; i < superList.size(); i++) {
            arr[i] = String.join(" ", superList.get(i));
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + "...";
        }

        //for (int i = 0; i < arr.length; i++) {
        //System.out.println(arr[i]);
        //}
        return arr;
    }
}