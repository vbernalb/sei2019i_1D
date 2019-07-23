package com.BusinessLogic;

import android.content.Context;

import com.DataAcces.Models.User;
import com.DataAcces.Repositories.CategoryRepository;
import com.DataAcces.Repositories.UserRepository;
import com.DataAcces.Repositories.WordRepository;
import com.Presentation.GameActivity;
import com.Presentation.PlayActivity;

import java.security.SecureRandom;
import java.util.ArrayList;

public class PlayController {
    public CategoryRepository categoryRepository;
    public WordRepository wordRepository;
    Context context;

    public PlayController(Context context) {
        this.categoryRepository = new CategoryRepository(context);
        this.wordRepository= new WordRepository(context);
        this.context = context;
    }

    /**
     * Esta funcion llama a WordRepository para crear una consulta de todas las palabras en la base de datos, dada la categoria y
     * la dificultad.
     * @param nameCategory
     * @param type
     */
    public void play(String nameCategory, String type){
        wordRepository.wordList("http://ahorcado1d.000webhostapp.com/get_all_word.php", nameCategory, type);
    }

    /**
     * Esta funcion coge la lista de palabras que envia el repositorio, elige una aleatoreamente y se la envia a la actividad.
     * En el caso de no haber palabras para dicha categoria y difficultad envia a la actividad un false.
     * @param arrayList
     */
    public void wordPlay(ArrayList<String> arrayList){
        final PlayActivity pa = (PlayActivity) context;
        String a;
        String  word= "false";
        String description = new String();
        String[] p;
        if(arrayList!=null){
            String[] m= new String[arrayList.size()];
            String[] d= new String[arrayList.size()];
            for(int i=0; i<arrayList.size(); i++){

                a = arrayList.get(i);
                p = a.split("\"");
                m[i]= p[3];
                d[i]= p[11];
            }
            SecureRandom sr= new SecureRandom();
            sr.nextBytes(new byte[1]);
            sr.nextInt(m.length);
            int i = sr.nextInt(m.length);
            word=m[i];
            description=d[i];
       }
        pa.nuevoIntent1(word, description, context);
    }

    /**
     * Esta funcion llamma a CategoryRepository y crea una consulta de todas las categorias dentro de la base de datos.
     */
    public void categoryList(){
        categoryRepository.categoryList("http://ahorcado1d.000webhostapp.com/get_all_category.php", 2);
    }

    /**
     * Esta funcion toma la respuesta delrepositorio y le envia la lista a la actividad.
     * @param arrayList
     */
    public void categoryList2 (ArrayList<String> arrayList){
        final PlayActivity pa = (PlayActivity) context;
        String a;
        String[] m= new String[arrayList.size()];
        String[] p;
        for(int i=0; i<arrayList.size(); i++){

            a = arrayList.get(i);

            p = a.split("\"");
            m[i]= p[3];
        }
        pa.nuevoIntentP(m, context);
    }

    /**
     * Esta funcion llama a UserRepository para hacer un update de los datos del score despues de ganar en el juego
     * @param emailUser
     * @param score
     */
    public void subirScore(String emailUser, int score){
        new UserRepository(context).update("http://ahorcado1d.000webhostapp.com/update_user.php", emailUser, score);
    }
}

