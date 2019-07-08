package com.BusinessLogic;

import android.content.Context;

import com.DataAcces.Models.Category;
import com.DataAcces.Models.User;
import com.DataAcces.Repositories.CategoryRepository;
import com.DataAcces.Repositories.UserRepository;

public class InsertCategoryController {
    Context context;
    CategoryRepository categoryRepository;
    public InsertCategoryController(Context context) {
        this.context = context;
        this.categoryRepository= new CategoryRepository(context);
    }
    public boolean InsertCategory (String name_category){
        if(this.CategoryExist(name_category)){
            Category category = new Category(name_category);
            categoryRepository.create(category, "http://ahorcado1d.000webhostapp.com/insert_user.php");
            return true;
        }
        else return false;
    }
    private boolean CategoryExist (String name_category){
        return true;
    }
}
