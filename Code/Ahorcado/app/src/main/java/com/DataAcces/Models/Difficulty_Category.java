package com.DataAcces.Models;

public class Difficulty_Category {
    private String name_category;
    private String type;
    private String name_word;

    public Difficulty_Category(String name_Category, String type, String name_word) {
        name_category = name_Category;
        this.type = type;
        this.name_word= name_word;
    }


    public String getName_Category() {
        return name_category;
    }

    public String getType() {
        return type;
    }

    public String getName_word() {
        return name_word;
    }
}
