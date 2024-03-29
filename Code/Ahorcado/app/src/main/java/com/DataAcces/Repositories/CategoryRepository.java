package com.DataAcces.Repositories;

import android.content.Context;
import android.widget.Toast;

import com.BusinessLogic.InsertCategoryController;

import com.BusinessLogic.InsertWordController;
//import com.BusinessLogic.PlayController;
import com.BusinessLogic.PlayController;
import com.DataAcces.Models.Category;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CategoryRepository {
    Category category;
    public Context context;
    boolean ook;
    boolean respuesta;

    public CategoryRepository(Context context) {
        this.category =null;
        this.context = context;
        this.ook=false;
        this.respuesta = true;
    }
    /**
     *Esta funcion crea una nueva entrada en la tabla User de la base de datos remota.
     * @param category EL modelo category que contiene los datos de la entrada.
     * @param URL  la URL del servidor donde se encuentra la base de datos example: http://192.162.1.3:80/Database/insertar.php
     */
    public void create (Category category, String URL){
        final String  name_category =category.getName_category();
        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonObject = new JSONObject(response);
                }catch (JSONException e ) {
                    System.out.println("exeption    "+ e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("***error" + error.getMessage());
                Toast.makeText(context, "Operacion fallida " + error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams()  {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("nameCategory", name_category);
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

    }
    public void delete (String name_category){}
    public void update (String name_category){}

    /**
     * Busca de acuerdo al parametro especificado en la URL
     * @param URL  la URL del servidor donde se encuentra la base de datos example: http://192.162.1.3:80/Database/insertar.php
     * @param name_category El nombre de la categoria por el cual se quiere buscar
     */
    public void getbyCategory(String URL, final String name_category){
        final String name_category_F = name_category;
        StringRequest jsonArrayRequest = new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(response);
                        Category category = null;
                        if(jsonObject.getBoolean("success")==true){
                            category= new Category(jsonObject.getString("nameCategory"));
                        }
                        new InsertCategoryController(context).categoryExist1(category, name_category_F);
                    } catch (JSONException e) {
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "problema en la conexion", Toast.LENGTH_SHORT).show();
            }
        }
        ){
            @Override
            protected Map<String, String> getParams()  {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("nameCategory",name_category_F);
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsonArrayRequest);
    }

    public void categoryList (String URL, final int option){
        final StringRequest jsonArrayRequest = new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONArray jsonArray =null;
                    try {
                        jsonArray= new JSONArray(response);
                        ArrayList arrayList= new ArrayList();
                        for (int j=0; j<jsonArray.length(); j++){
                            arrayList.add(j, jsonArray.getString(j));
                        }
                        switch (option){
                            case 1: {
                                new InsertWordController(context).showCategoryAnswer(arrayList);
                                break;
                            }
                            case 2: {
                                new PlayController(context).categoryList2(arrayList);
                                break;
                            }
                        }


                    } catch (JSONException e) {
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "problema en la conexion", Toast.LENGTH_SHORT).show();
            }
        }
        ){
            @Override
            protected Map<String, String> getParams()  {
                /*Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("name_category",name_category_F);
                parametros.put("type",type_F);
                parametros.put("name_word",name_word_F);
                return parametros;*/
                return null;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsonArrayRequest);
    }


}
