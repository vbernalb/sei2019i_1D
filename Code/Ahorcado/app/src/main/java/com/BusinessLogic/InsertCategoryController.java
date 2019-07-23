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

    /**
     * Esta funcion busca si ya existe una categoria almacenada en la base de datos
     * @param name_category
     */
    public void InsertCategory (String name_category){
        new CategoryRepository(context).getbyCategory("http://ahorcado1d.000webhostapp.com/get_category.php", name_category);
    }

    /**
     * Esta funcion crea en la tabla Difficulty_Category los registros de la nueva categoria junto con cada dificultad
     * @param name_category
     */
    public void InsertDiffCat (String name_category){
        new Difficulty_CategoryRepository(context).create(new Difficulty_Category(0,name_category,""), "http://ahorcado1d.000webhostapp.com/insert_difficulty_category.php");
    }

    /**
     * Esta funcion verifica si la categori ingresada ya existe, de no ser asi la crea en la vase de datos. Luego
     * vuelve a la actividad con la respuesta de si se creo la categoria, o esta ya existe.
     * @param category
     * @param name_category
     */
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



}
