package com.DataAcces.Models;

public class Difficulty {
    private String type;
    private short score;

    public Difficulty(String type, short score) {
        this.type = type;
        this.score = score;
    }


    public String getType() {
        return type;
    }

    public short getScore() {
        return score;
    }

}
