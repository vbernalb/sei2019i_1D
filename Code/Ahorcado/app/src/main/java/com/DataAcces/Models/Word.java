package com.DataAcces.Models;

public class Word {
    private String Name_Word;
    private String Description;

    public Word(String name_word, String dscription) {
        Name_Word = name_word;
        Description = dscription;
    }

    public Word() {
        Name_Word= null;
        Description= null;
    }

    public String getName_Word() {
        return Name_Word;
    }

    public void setName_Word(String name_word) {
        Name_Word = name_word;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
