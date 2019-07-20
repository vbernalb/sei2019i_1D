package com.DataAcces.Repositories;

import android.content.Context;
import android.widget.Toast;

import com.BusinessLogic.InsertCategoryController;
import com.DataAcces.Models.Category;
import com.DataAcces.Models.Difficulty_Category;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Difficulty_CategoryRepository {
    Difficulty_Category difficulty_category;
    Context context;
    boolean ook;
    boolean respuesta;

    public Difficulty_CategoryRepository(Context context) {
        this.context = context;
        this.difficulty_category= null;
        this.ook=false;
        this.respuesta = true;
    }

    /**
     *Esta funcion crea una nueva entrada en la tabla User de la base de datos remota.
     * @param difficulty_category EL modelo Difficulty_Category que contiene los datos de la entrada.
     * @param URL  la URL del servidor donde se encuentra la base de datos example: http://192.162.1.3:80/Database/insertar.php
     * @return si se realizo todo el proceso de comunicacion con la base de datos
     */
    public void create (Difficulty_Category difficulty_category, String URL){;
        final String  name_category= difficulty_category.getName_Category();
        final String type= difficulty_category.getType();

        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("respuesta " + response);
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
                parametros.put("type", type);
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

    }
    public void delete (String id_diff_cat){}
    public void update (Difficulty_Category difficulty_category){}
    /**
     *Busca de acuerdo al parametro especificado en la URL
     * @param URL  la URL del servidor donde se encuentra la base de datos example: http://192.162.1.3:80/Database/insertar.php
     * @return Un objeto Difficulty_Category, con los datos obtenidos, null si no encuentra nada.
     */
    public void getbyDifficulty_Category(String URL, final String name_category, final String type ){
        final String name_category_F = name_category;
        final String type_F = type;
        StringRequest jsonArrayRequest = new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject jsonObject = null;

                    try {
                        jsonObject = new JSONObject(response);
                        Difficulty_Category difficulty_category=null;
                        if(jsonObject.getBoolean("success")==true){
                            difficulty_category= new Difficulty_Category(jsonObject.getString("name_category"),
                                    jsonObject.getString("type"));   
                        }
                        //new InsertCategoryController(context).categoryExist1(category, name_category_F); preguntar vale
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
                parametros.put("type",type_F);
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsonArrayRequest);
    }
}
