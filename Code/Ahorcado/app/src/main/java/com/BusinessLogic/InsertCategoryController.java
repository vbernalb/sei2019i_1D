package com.BusinessLogic;

import android.content.Context;

import com.DataAcces.Models.Category;
import com.DataAcces.Models.User;
import com.DataAcces.Repositories.CategoryRepository;
import com.DataAcces.Repositories.UserRepository;

public class InsertCategoryController {
    Context context;
    static boolean exist;
    CategoryRepository categoryRepository;

    public InsertCategoryController(Context context) {
        this.context = context;
        this.categoryRepository= new CategoryRepository(context);
    }

    public boolean InsertCategory (String name_category){
        Category category = new Category(name_category);
        if(exist){
            categoryRepository.create(category, "http://ahorcado1d.000webhostapp.com/insert_category.php");
            return true;
        }
        else return false;
    }
    private void categoryExist (String name_category){
        categoryRepository.getbyCategory("http://ahorcado1d.000webhostapp.com/get_category.php", name_category);
    }
    public static void categoryExist1(Category category){
        exist= category!=null;
    }
}
