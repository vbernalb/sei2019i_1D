package com.BusinessLogic;

import android.content.Context;

import com.DataAcces.Repositories.CategoryRepository;
import com.DataAcces.Repositories.WordRepository;
import com.Presentation.GameActivity;
import com.Presentation.PlayActivity;

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

    public void play(){
        //wordRepository.wordList();
    }
    public void wordPlay(ArrayList<String> arrayList){
        final GameActivity ma = (GameActivity) context;
        String a;
        String[] m= new String[arrayList.size()];
        String[] p;
        for(int i=0; i<arrayList.size(); i++){

            a = arrayList.get(i);

            p = a.split("\"");
            m[i]= p[3];
        }
        String  word= null;
        int aleatorio;
        aleatorio = (int) Math.random()*m.length;
        word = m[aleatorio];

        //ma.nuevoIntent1(word, context);
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
}

