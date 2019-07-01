package com.DataAcces.Models;

public class Category {
    private String Name_Category;

    public Category(String name_Category) {
        Name_Category = name_Category;
    }

    public Category() {
        Name_Category= null;
    }

    public String getName_Category() {
        return Name_Category;
    }

    public void setName_Category(String name_Category) {
        Name_Category = name_Category;
    }
}
