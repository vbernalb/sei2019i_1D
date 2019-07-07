package com.BusinessLogic;

import android.content.Context;

import com.DataAcces.Models.Difficulty_Category;
import com.DataAcces.Models.Word;
import com.DataAcces.Repositories.WordRepository;

public class InsertWordController {
    Context context;

    public InsertWordController(Context context){ this.context=context; }

    /**
     * Esta funcion registra una nueva palabra en la applicacion, haciendo llamado a la clase DifficulttRepository, CategoryRepository, WordRepository,  .
     * @param word palabra que se va a ingresar
     * @param description descripcion/pista de la palabra.
     * @param category categoria de la palabra
     * @param difficulty dificultad de la palabra
     * @return si la insercion fue exitosa
     */
    public void insert(String word, String description, String category, String difficulty){
            Word word1 = new Word(word, description);
            Difficulty_Category d_c = new Difficulty_Category(category,difficulty,word);
            //FALTA REPOSITORIO DEFFICULTY_CATEGORY
            WordRepository wordRepository = new WordRepository(context);
            //System.out.println("*******entre al sign insertWORD");
            wordRepository.create(word1, "http://ahorcado1d.000webhostapp.com/insert_word.php");

    }
}
