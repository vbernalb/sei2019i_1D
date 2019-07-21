package com.DataAcces.Models;

public class Word {
    private String name_word;
    private String description;
    private int diff_cat;

    public Word(String name_word, String description, int diff_cat) {
        this.name_word = name_word;
        this.description = description;
        this.diff_cat = diff_cat;
    }

    /**
     *
     * @return nombre de la palabra
     */
    public String getName_Word() {
        return name_word;
    }

    /**
     *
     * @return descripcion de la palabra
     */
    public String getDescription() {
        return description;
    }

    /***
     *
     * @return indice del difficult_category
     */
    public int getDiff_cat() {
        return diff_cat;
    }
}
