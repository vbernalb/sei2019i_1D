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

    public void play(String nameCategory, String type){
        wordRepository.wordList("http://ahorcado1d.000webhostapp.com/get_all_word.php", nameCategory, type);
    }
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
            System.out.println("STRING: " + a);
            p = a.split("\"");
            m[i]= p[3];
            d[i]= p[11];
        }
            //int aleatorio;
            //aleatorio = (int) (Math.random()*m.length);
            //word = m[aleatorio];
            SecureRandom sr= new SecureRandom();
            sr.nextBytes(new byte[1]);
            sr.nextInt(m.length);
            int i = sr.nextInt(m.length);
            word=m[i];
            description=d[i];
       }

        pa.nuevoIntent1(word, description, context);
    }


    public void categoryList(){
        categoryRepository.categoryList("http://ahorcado1d.000webhostapp.com/get_all_category.php", 2);
    }
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

    public void subirScore(String emailUser, int score){
        new UserRepository(context).update("http://ahorcado1d.000webhostapp.com/update_user.php", emailUser, score);
    }
}

