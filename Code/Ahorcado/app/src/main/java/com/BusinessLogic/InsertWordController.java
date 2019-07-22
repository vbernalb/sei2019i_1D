package com.BusinessLogic;

import android.content.Context;

import com.DataAcces.Models.Difficulty_Category;
import com.DataAcces.Models.Word;
import com.DataAcces.Repositories.CategoryRepository;
import com.DataAcces.Repositories.Difficulty_CategoryRepository;
import com.DataAcces.Repositories.WordRepository;
import com.Presentation.WordActivity;

import java.util.ArrayList;

public class InsertWordController {
    Context context;
    WordRepository wordRepository;
    Difficulty_CategoryRepository difficulty_categoryRepository;
    CategoryRepository categoryRepository;
   static Word w;

    public InsertWordController(Context context){
        this.context=context;
        this.wordRepository = new WordRepository(context);
        this.difficulty_categoryRepository= new Difficulty_CategoryRepository(context);
        this.categoryRepository = new CategoryRepository(context);
    }

    /*/**
     * Esta funcion busca en la base de datos todas las categorias dentro de la aplicacion
     */
    public void showCategory(){
        categoryRepository.categoryList("http://ahorcado1d.000webhostapp.com/get_all_category.php", 1);
    }

    /**
     * Esta funcian toda el arreglo de todas las categorias desde el repocitorio y se las envia de regreso a la actividad.
     * @param arrayList
     */
    public void showCategoryAnswer(ArrayList<String> arrayList){
        final WordActivity wa = (WordActivity) context;
        String a;
        String[] m= new String[arrayList.size()];
        String[] p;
        for(int i=0; i<arrayList.size(); i++){

            a = arrayList.get(i);

             p = a.split("\"");
             m[i]= p[3];
        }

       wa.nuevoIntent(m, context);

        }

    /**
     * Esta funcion busca una difficulty_category segun la categoria y dificultad que llegan desde la actividad
     * @param name_word
     * @param description
     * @param name_category
     * @param name_difficulty
     */
    public void InsertWord (String name_word, String description, String name_category, String name_difficulty){
        w = new Word(name_word,description,0);
        difficulty_categoryRepository.getbyDifficulty_Category("http://ahorcado1d.000webhostapp.com/get_difficulty_category.php",name_category,name_difficulty);
    }


    /**
     * Esta funcion coge lo que le envia el repositorio Difficulty_Category, le añade a w el id_diff_cat, y llama a wordExist
     * @param dc
     * @param id_diff_cat
     */
    public void IdDiffCatAnswer(Difficulty_Category dc, int id_diff_cat){
        if(dc!= null){
            w.setDiff_cat(id_diff_cat);
            wordExist(w.getName_Word(), w.getDescription(), w.getDiff_cat());
        }
    }

    /**
     * Esta funcion verifica que la palabra a ingresar ya exista.
     * @param name_word
     * @param description
     * @param id_diff_cat
     */
    private void wordExist (String name_word, String description, int id_diff_cat){
        wordRepository.getbyword("http://ahorcado1d.000webhostapp.com/get_word.php", name_word,description,id_diff_cat);
    }

    /**
     * Esta funcion recive la respuesta del WordRepository, de ser que la palabra a ingresar no exista la crea; luego
     * envia la respuesta de si existe o no a la actividad.
     * @param word
     * @param name_word
     * @param description
     * @param id_diff_cat
     */
    public  void wordExist1(Word word, String name_word, String description, int id_diff_cat){
        boolean confirm =false;
        final WordActivity ca= (WordActivity) context;
        if(word== null){
            confirm=true;
            wordRepository.create(new Word(w.getName_Word(),w.getDescription(),w.getDiff_cat()), "http://ahorcado1d.000webhostapp.com/insert_word.php");
        }
       ca.nuevoIntent1(confirm, context);
    }



}
