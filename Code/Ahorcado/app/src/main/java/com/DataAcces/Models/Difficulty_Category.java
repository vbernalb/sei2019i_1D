package com.DataAcces.Models;

public class Difficulty_Category {
    private int id_diff_cat;
    private String name_category;
    private int type;
    private String name_word;

    public Difficulty_Category(int id_diff_cat, String name_Category, int type, String name_word) {
        this.id_diff_cat = id_diff_cat;
        name_category = name_Category;
        this.type = type;
        this.name_word= name_word;
    }

    public int getId_diff_cat() { return id_diff_cat; }

    public String getName_Category() {
        return name_category;
    }

    public int getType() {
        return type;
    }

    public String getName_word() {
        return name_word;
    }
}
