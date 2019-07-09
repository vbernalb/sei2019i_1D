package com.DataAcces.Repositories;

import android.content.Context;
import android.widget.Toast;

import com.BusinessLogic.InsertCategoryController;
import com.BusinessLogic.LoginAdminController;
import com.BusinessLogic.SignInUserController;
import com.DataAcces.Models.Admin;
import com.DataAcces.Models.Category;
import com.DataAcces.Models.User;
import com.android.volley.AuthFailureError;
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

public class CategoryRepository {
    Category category;
    Context context;
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
        System.out.println("*******entre al category repositori");
        boolean operacion= false;
        final String  name_category =category.getName_category();

        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                System.out.println("*******on ** respuesta");
                System.out.println("respuesta " + response);
                try{
                    JSONObject jsonObject = new JSONObject(response);
                    System.out.println("*******respuesta");
                    ook = jsonObject.getBoolean("success");
                    if(ook){
                        Toast.makeText(context, "INSERCION EXITOSA",Toast.LENGTH_SHORT).show();
                    }

                }catch (JSONException e ) {
                    System.out.println("*******exception");
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
                parametros.put("name_category", name_category);

                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
        operacion = true;
        System.out.println("**********estado del sistemas   "+ ook);

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
        System.out.println("*** login admin repository");
        StringRequest jsonArrayRequest = new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("*** login admin on repose ");
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        System.out.println("*** login admin *** on repose");
                        jsonObject = new JSONObject(response);
                        Category category=null;
                        if(jsonObject.getBoolean("success")==true){
                            category= new Category(jsonObject.getString("name_category"));
                        }
                        new InsertCategoryController(context).categoryExist1(category, name_category_F);
                    } catch (JSONException e) {
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
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
                parametros.put("name_category",name_category_F);
                System.out.println("*** login admin parametros");
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsonArrayRequest);
        return ;
    }

}
