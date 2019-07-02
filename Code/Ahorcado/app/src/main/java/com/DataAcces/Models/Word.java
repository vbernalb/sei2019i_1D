package com.DataAcces.Models;

public class Word {
    private String name_word;
    private String description;

    public Word(String name_word, String description) {
        this.name_word = name_word;
        this.description = description;
    }

    public String getName_Word() {
        return name_word;
    }
    public String getDescription() {
        return description;
    }

}
