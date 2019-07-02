package com.DataAcces.Models;

public class Difficulty {
    private String type;
    private short score;

    public Difficulty(int type, short score) {
        this.type = type;
        this.score = score;
    }


    public int getType() {
        return type;
    }

    public short getScore() {
        return score;
    }

}
