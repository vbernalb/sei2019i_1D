package com.BusinessLogic;

import android.content.Context;

import com.DataAcces.Models.Difficulty_Category;
import com.DataAcces.Models.Word;
import com.DataAcces.Repositories.CategoryRepository;
import com.DataAcces.Repositories.Difficulty_CategoryRepository;
import com.DataAcces.Repositories.WordRepository;
import com.Presentation.WordActivity;

public class InsertWordController {
    Context context;
    WordRepository wordRepository;
    Difficulty_CategoryRepository difficulty_categoryRepository;
    CategoryRepository categoryRepository;

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

    }

    public void InsertWord (String name_word, String description, String name_category, String name_difficulty){
        //wordExist(name_word, description, name_category, name_difficulty);
    }
    private void wordExist (String name_word){
        //wordRepository.getbyword("http://ahorcado1d.000webhostapp.com/get_word.php", name_word, description);
    }
    public  void wordExist1(Word word, String name_word, String description, String name_category, String name_difficulty){
        boolean confirm =false;
        final WordActivity ca= (WordActivity) context;
        if(word!= null){
            confirm=true;
            wordRepository.create(new Word(name_word,description), "http://ahorcado1d.000webhostapp.com/insert_word.php");
            difficulty_categoryRepository.create(new Difficulty_Category(name_category,name_difficulty,name_word),"http://ahorcado1d.000webhostapp.com/insert_difficulty_category.php");
        }
       // ca.nuevoIntent(confirm, context);
    }
}
