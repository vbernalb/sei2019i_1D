package com.DataAcces.Models;

public class Difficulty_Category {
    private int id;
    private String name_category;
    private String type;

    public Difficulty_Category(int id, String name_Category, String type) {
        this.id=id;
        name_category = name_Category;
        this.type = type;
    }


    public String getName_Category() {
        return name_category;
    }


    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }


}
