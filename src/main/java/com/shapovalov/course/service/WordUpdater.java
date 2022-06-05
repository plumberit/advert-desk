package com.shapovalov.course.service;

import java.util.ArrayList;

public class WordUpdater {

    char [] banList = {'!', '?', '%', '#', '@', '"', ';' ':', ',', '<', '>', '(',
            ')', '-', '_', '=', '+', '&', '^', '$', '*', '№', '.'};

    public String update(String word) {

        char [] charArrOfSymbols = word.toCharArray();
        ArrayList<Character> charListOfSymbols = new ArrayList<>();

        for (int i = 0; i < charListOfSymbols.size(); i++) {
            for (int j = 0; j < banList.length; j++) {
                if (charListOfSymbols.get(i)==banList[j]) {
                    charListOfSymbols.remove(i);
                    i = 0;
                    j = 0;
                }
            }
        }

        ArrayList<String> stringListOfSymbols = new ArrayList<>();
        for (int i = 0; i < charListOfSymbols.size(); i++) {
            stringListOfSymbols.add(charListOfSymbols.get(i).toString());
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringListOfSymbols.size(); i++) {
            stringBuilder.append(stringListOfSymbols.get(i));
        }

        return stringBuilder.toString();
    }
}
