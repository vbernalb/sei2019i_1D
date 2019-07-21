package com.BusinessLogic;

import android.content.Context;

import com.DataAcces.Models.Category;
import com.DataAcces.Models.Difficulty_Category;
import com.DataAcces.Models.User;
import com.DataAcces.Repositories.CategoryRepository;
import com.DataAcces.Repositories.Difficulty_CategoryRepository;
import com.DataAcces.Repositories.UserRepository;
import com.Presentation.CategoryActivity;
import com.Presentation.RegisterActivity;

public class InsertCategoryController {
    final Context context;

    public InsertCategoryController(Context context) {
        this.context = context;
    }

    public void InsertCategory (String name_category){
        new CategoryRepository(context).getbyCategory("http://ahorcado1d.000webhostapp.com/get_category.php", name_category);
    }

    public void InsertDiffCat (String name_category){
        new Difficulty_CategoryRepository(context).create(new Difficulty_Category(0,name_category,""), "http://ahorcado1d.000webhostapp.com/insert_difficulty_category.php");
    }


    public  void categoryExist1(Category category, String name_category){
        boolean confirm =false;
        final CategoryActivity ca= (CategoryActivity) context;
        if(category==null){
            confirm=true;
            System.out.println(name_category);
            new CategoryRepository(context).create(new Category(name_category), "http://ahorcado1d.000webhostapp.com/insert_category.php");
        }
        ca.nuevoIntent(confirm, context);
    }

    public  void diff_cat_create(Difficulty_Category dc, String name_category){
        boolean confirm =true;
        final CategoryActivity ca= (CategoryActivity) context;
        new Difficulty_CategoryRepository(context).create(new Difficulty_Category(0,name_category,""), "http://ahorcado1d.000webhostapp.com/insert_difficulty_category cvf.php");

        ca.nuevoIntent1(confirm, context);
    }


}
