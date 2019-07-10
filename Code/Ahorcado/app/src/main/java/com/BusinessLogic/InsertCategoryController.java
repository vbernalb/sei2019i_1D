package com.BusinessLogic;

import android.content.Context;

import com.DataAcces.Models.Category;
import com.DataAcces.Models.User;
import com.DataAcces.Repositories.CategoryRepository;
import com.DataAcces.Repositories.UserRepository;
import com.Presentation.CategoryActivity;
import com.Presentation.RegisterActivity;

public class InsertCategoryController {
    final Context context;

    public InsertCategoryController(Context context) {
        this.context = context;
    }

    public void InsertCategory (String name_category){
        System.out.println("papas2");
        new CategoryRepository(context).getbyCategory("http://ahorcado1d.000webhostapp.com/get_category.php", name_category);
    }
    public  void categoryExist1(Category category, String name_category){
        boolean confirm =false;
        final CategoryActivity ca= (CategoryActivity) context;
        if(category==null){
            System.out.println("papas4");
            confirm=true;
            new CategoryRepository(context).create(new Category(name_category), "http://ahorcado1d.000webhostapp.com/insert_category.php");
        }
        ca.nuevoIntent(confirm, context);
    }
}
