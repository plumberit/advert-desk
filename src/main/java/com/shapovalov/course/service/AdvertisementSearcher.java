package com.shapovalov.course.service;

import com.shapovalov.course.model.Advertisement;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class AdvertisementSearcher {

    public static Long [] searchAdvertsID(Iterable<Advertisement> advertisements, String searchInput) {
        ArrayList<Advertisement> advertisementsList = new ArrayList<>();
        for(Advertisement adv : advertisements) {
            advertisementsList.add(adv);
        }
        ArrayList<AdvertisementSearchModel> searchedAdvertsWords =
            AdvertisementMaterials.searchAdvertModelListCreate(advertisementsList);

        ArrayList<AdvertisementSearchModel> searchedAdvertsWordsUpdate =
                CustomizeSearchWords.customize(searchedAdvertsWords);

        ArrayList<Long> listOfSearchedAdvertsID = new ArrayList<>();

        for (int i = 0; i < searchedAdvertsWordsUpdate.size(); i++) {
            for (int j = 0; j < searchedAdvertsWordsUpdate.get(i).getListOfWords().size(); j++) {
                if (searchInput.equals(searchedAdvertsWordsUpdate.get(i).getListOfWords().get(j))) {
                    listOfSearchedAdvertsID.add(searchedAdvertsWordsUpdate.get(i).getId());
                    ArrayList<AdvertisementSearchModel> searchedAdvertsWordsUpdate =
                            CustomizeSearchWords.customize(searchedAdvertsWords);
                }
            }
        }

        //уникальные элементы
        Set<Long> setOfID = new LinkedHashSet<>(listOfSearchedAdvertsID);
        Long [] arr = new Long[setOfID.size()];
        setOfID.toArray(arr);
        return arr;
    }
}
