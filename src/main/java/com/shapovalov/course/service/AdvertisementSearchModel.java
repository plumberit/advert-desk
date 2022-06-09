package com.shapovalov.course.service;

import java.util.ArrayList;

public class AdvertisementSearchModel {

    private Long id;
    private ArrayList<String> listOfWords;


    public AdvertisementSearchModel() {
    }

    public AdvertisementSearchModel(Long id, ArrayList<String> listOfWords) {
        this.id = id;
        this.listOfWords = listOfWords;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<String> getListOfWords() {
        return listOfWords;
    }

    public void setListOfWords(ArrayList<String> listOfWords) {
        this.listOfWords = listOfWords;
    }
}
