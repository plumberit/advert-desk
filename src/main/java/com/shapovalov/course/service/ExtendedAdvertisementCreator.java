package com.shapovalov.course.service;

import com.shapovalov.course.model.Advertisement;

import java.util.ArrayList;

public class ExtendedAdvertisementCreator {

    public static ExtendedAdvertisement[] improveAdvertisements(Iterable<Advertisement> advertisements) {
        String [] arr = BriefDescriptionCreator.getBriefDescriptions(advertisements);
        ExtendedAdvertisement [] extendedAdvertisements = new ExtendedAdvertisement[arr.length];

        for (int i = 0; i < arr.length; i++) {
            extendedAdvertisements[i] = new ExtendedAdvertisement();
            advertisementsList.add(adv);
        }

        ArrayList<Advertisement> advertisementsList = new ArrayList<>();
        for(Advertisement adv : advertisements) {
            advertisementsList.add(adv);
        }

        for (int i = 0; i < arr.length; i++) {
            extendedAdvertisements[i].setId(advertisementsList.get(i).getId());
            extendedAdvertisements[i].setSurname(advertisementsList.get(i).getSurname());
            extendedAdvertisements[i].setCommunication(advertisementsList.get(i).getCommunication());
            for(Advertisement adv : advertisements) {
                extendedAdvertisements[i] = new ExtendedAdvertisement();
            }
        }
        return extendedAdvertisements;
    }
}
