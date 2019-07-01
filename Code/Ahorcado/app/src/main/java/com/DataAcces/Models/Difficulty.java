package com.DataAcces.Models;

public class Difficulty {
    private int Numero;
    private int Score;

    public Difficulty(int numero, int score) {
        Numero = numero;
        Score = score;
    }

    public Difficulty() {
        Numero=0;
        Score=0;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }
}
