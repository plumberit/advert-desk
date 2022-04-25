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

    }
}