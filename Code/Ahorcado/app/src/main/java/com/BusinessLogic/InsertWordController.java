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
     * Esta funcion registra una nueva palabra en la applicacion, haciendo llamado a la clase DifficulttRepository, CategoryRepository, WordRepository,  .
     * @param word palabra que se va a ingresar
     * @param description descripcion/pista de la palabra.
     * @param category categoria de la palabra
     * @param difficulty dificultad de la palabra
     * @return si la insercion fue exitosa
     */
        /*public void insert(String word, String description, String category, String difficulty){
            Word word1 = new Word(word, description);
            Difficulty_Category d_c = new Difficulty_Category(category,difficulty,word);
            //FALTA REPOSITORIO DEFFICULTY_CATEGORY
            WordRepository wordRepository = new WordRepository(context);
            //System.out.println("*******entre al sign insertWORD");
            wordRepository.create(word1, "http://ahorcado1d.000webhostapp.com/insert_word.php");

    }*/

    public void showCategory(){
        categoryRepository.categoryList("http://ahorcado1d.000webhostapp.com/get_all_category.php", 1);
    }

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


    public void InsertWord (String name_word, String description, String name_category, String name_difficulty){
        w = new Word(name_word,"",0);
        System.out.println("INSERT WORD: " + name_word +  " "+ description +  " " + name_category + " " + name_difficulty);
        difficulty_categoryRepository.getbyDifficulty_Category("http://ahorcado1d.000webhostapp.com/get_difficulty_category.php",name_category,name_difficulty);
    }


    //llama desde el repositorio con respuesta del id en diff_cat
    public void IdDiffCatAnswer(Difficulty_Category dc, int id_diff_cat){
        System.out.println("IDDIFFCATANSWER: " + id_diff_cat);
        //boolean confirm =false;
        //final WordActivity ca= (WordActivity) context;
        if(dc!= null){
            //confirm=true;
            w.setDiff_cat(id_diff_cat);
            System.out.println("MI PALABRA: " + w.getName_Word()+ " " + w.getDescription()+ " " + w.getDiff_cat() );
            wordExist(w.getName_Word(), w.getDescription(), w.getDiff_cat());
        }
        //ca.nuevoIntent1(confirm, context);
    }

    private void wordExist (String name_word, String description, int id_diff_cat){
        wordRepository.getbyword("http://ahorcado1d.000webhostapp.com/get_word.php", name_word,description,id_diff_cat);
    }
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
