package com.BusinessLogic;

import android.content.Context;

import com.DataAcces.Repositories.CategoryRepository;
import com.DataAcces.Repositories.Difficulty_CategoryRepository;
import com.DataAcces.Repositories.WordRepository;
import com.Presentation.PlayActivity;
import com.Presentation.WordActivity;

import java.util.ArrayList;

public class SelectGameController {
    Context context;
    WordRepository wordRepository;
    Difficulty_CategoryRepository difficulty_categoryRepository;
    CategoryRepository categoryRepository;

    public SelectGameController(Context context) {
        this.context = context;
        this.wordRepository = wordRepository;
        this.difficulty_categoryRepository = difficulty_categoryRepository;
        this.categoryRepository = categoryRepository;
    }


    public void showCategory1(){
        //categoryRepository.gameCategoryList("http://ahorcado1d.000webhostapp.com/get_all_category.php");
    }

    public void showCategoryAns(ArrayList<String> arrayList){
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
