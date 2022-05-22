package com.shapovalov.course.service;

import java.util.ArrayList;

public class CustomizeSearchWords {

    public static ArrayList<AdvertisementSearchModel> customize(ArrayList<AdvertisementSearchModel> searchedAdvertsWords) {

        ArrayList<AdvertisementSearchModel> updateList = new ArrayList<>();

        for (int i = 0; i < searchedAdvertsWords.size(); i++) {
            updateList.add(new AdvertisementSearchModel());
            updateList.get(i).setListOfWords(new ArrayList<>());
        }

        for (int i = 0; i < searchedAdvertsWords.size(); i++) {
            for (int j = 0; j < searchedAdvertsWords.get(i).getListOfWords().size(); j++) {
                String word = searchedAdvertsWords.get(i).getListOfWords().get(j);
                String updatedWord = wordUpdater.update(word);
                updateList.get(i).getListOfWords().add(j, updatedWord);
            }
        }

        return updateList;
    }

}
