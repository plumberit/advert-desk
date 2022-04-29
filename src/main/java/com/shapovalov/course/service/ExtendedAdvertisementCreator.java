package com.shapovalov.course.service;

import com.shapovalov.course.model.Advertisement;

import java.util.ArrayList;

public class ExtendedAdvertisementCreator {

    public static ExtendedAdvertisement[] improveAdvertisements(Iterable<Advertisement> advertisements) {
        String [] arr = BriefDescriptionCreator.getBriefDescriptions(advertisements);
        ExtendedAdvertisement [] extendedAdvertisements = new ExtendedAdvertisement[arr.length];

        ArrayList<Advertisement> advertisementsList = new ArrayList<>();
        for(Advertisement adv : advertisements) {
            advertisementsList.add(adv);
        }

        for (int i = 0; i < arr.length; i++) {
            extendedAdvertisements[i] = new ExtendedAdvertisement();
        }

        for (int i = 0; i < arr.length; i++) {
            extendedAdvertisements[i].setId(advertisementsList.get(i).getId());
            extendedAdvertisements[i].setClientID(advertisementsList.get(i).getClientID());
            extendedAdvertisements[i].setName(advertisementsList.get(i).getName());
            extendedAdvertisements[i].setSurname(advertisementsList.get(i).getSurname());
            extendedAdvertisements[i].setCommunication(advertisementsList.get(i).getCommunication());
            extendedAdvertisements[i].setDescription(advertisementsList.get(i).getDescription());
            extendedAdvertisements[i].setBriefDescription(arr[i]);
        }
        return extendedAdvertisements;
    }
}
