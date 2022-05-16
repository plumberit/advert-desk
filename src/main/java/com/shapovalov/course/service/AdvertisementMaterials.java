package com.shapovalov.course.service;

import com.shapovalov.course.model.Advertisement;

import java.util.ArrayList;
import java.util.Arrays;

public class AdvertisementMaterials {


    public static ArrayList<AdvertisementSearchModel> searchAdvertModelListCreate(ArrayList<Advertisement> advertisements) {
        ArrayList<AdvertisementSearchModel> searchAdvertModelList =
                new ArrayList<>();
        for (int i = 0; i < advertisements.size(); i++) {
            String name = advertisements.get(i).getName();
            String surname = advertisements.get(i).getSurname();
            String communication = advertisements.get(i).getCommunication();
            String description = advertisements.get(i).getDescription();

            String [] communicationArr = communication.split(" ");
            String [] descriptionArr = description.split(" ");

            ArrayList<String> materialsList = new ArrayList<>();
            materialsList.add(name);
            materialsList.add(surname);
            materialsList.addAll(Arrays.asList(communicationArr));
            materialsList.addAll(Arrays.asList(descriptionArr));
            searchAdvertModelList.add(new AdvertisementSearchModel(advertisements.get(i).getId(), materialsList));
        }
        return searchAdvertModelList;
    }
}
