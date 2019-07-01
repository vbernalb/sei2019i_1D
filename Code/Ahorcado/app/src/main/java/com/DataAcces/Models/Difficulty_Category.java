package com.DataAcces.Models;

public class Difficulty_Category {
    private int Id_Diff_Cat;
    private String Name_Category;
    private int Numero;

    public Difficulty_Category(int id_Level, String name_Category, int numero) {
        Id_Diff_Cat = id_Level;
        Name_Category = name_Category;
        Numero = numero;
    }

    public Difficulty_Category() {
        Id_Diff_Cat = 0;
        Name_Category = null;
        Numero = 0;
    }

    public int getId_Diff_Cat() {
        return Id_Diff_Cat;
    }

    public void setId_Diff_Cat(int id_Diff_Cat) {
        Id_Diff_Cat = id_Diff_Cat;
    }

    public String getName_Category() {
        return Name_Category;
    }

    public void setName_Category(String name_Category) {
        Name_Category = name_Category;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }
}
