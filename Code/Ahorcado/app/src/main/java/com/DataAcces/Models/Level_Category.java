package com.DataAcces.Models;

public class Level_Category {
    private int Id_Level;
    private String Name_Category;
    private int Numero;

    public Level_Category(int id_Level, String name_Category, int numero) {
        Id_Level = id_Level;
        Name_Category = name_Category;
        Numero = numero;
    }

    public Level_Category() {
        Id_Level = 0;
        Name_Category = null;
        Numero = 0;
    }

    public int getId_Level() {
        return Id_Level;
    }

    public void setId_Level(int id_Level) {
        Id_Level = id_Level;
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
