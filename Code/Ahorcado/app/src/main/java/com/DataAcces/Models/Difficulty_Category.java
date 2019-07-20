package com.DataAcces.Models;

public class Difficulty_Category {
    private String name_category;
    private String type;

    public Difficulty_Category(String name_Category, String type, String name_word) {
        name_category = name_Category;
        this.type = type;
    }


    public String getName_Category() {
        return name_category;
    }

    public String getType() {
        return type;
    }

}
