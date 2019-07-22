package com.DataAcces.Repositories;

import android.content.Context;
import android.widget.Toast;

import com.BusinessLogic.InsertWordController;
import com.BusinessLogic.PlayController;
import com.BusinessLogic.ScoreViewController;
import com.DataAcces.Models.Word;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordRepository {

    Word word;
    Context context;

    public WordRepository( Context context) {
        this.word = null;
        this.context = context;
    }


    /**
     *Esta funcion crea una nueva entrada en la tabla User de la base de datos remota.
     * @param word EL modelo Word que contiene los datos de la entrada.
     * @param URL  la URL del servidor donde se encuentra la base de datos example: http://192.162.1.3:80/Database/insertar.php
     * @return
     */
    public void create (Word word, String URL){
        System.out.println("*******entre al user repositori");
        boolean operacion= false;
        final String  palabra =word.getName_Word();
        final String  descripcion =word.getDescription();
        final String  id_f = Integer.toString(word.getDiff_cat());


        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                System.out.println("*******on ** respuesta");
                System.out.println("respuesta " + response);
                try{
                    JSONObject jsonObject = new JSONObject(response);
                    System.out.println("*******respuesta");

                    if(jsonObject.getBoolean("success")){
                        Toast.makeText(context, "REGISTRO EXITOSO",Toast.LENGTH_SHORT).show();
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
                parametros.put("nameWord",palabra);
                parametros.put("description",descripcion);
                parametros.put("diff_cat",id_f);
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


        return ;

    }



    public void delete (String name_word){}

    /**
     * Busca de acuerdo al parametro especificado en la URL
     * @param URL  la URL del servidor donde se encuentra la base de datos example: http://192.162.1.3:80/Database/insertar.php
     * @param word El email por el cual se quiere buscar
     */
    public void getbyword(String URL, String word, String description, final int id_diff_cat){
        final String word_f = word;
        final String description_f = description;
        final int id_f = id_diff_cat;
        StringRequest jsonArrayRequest = new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject jsonObject = null;

                try {
                    jsonObject = new JSONObject(response);
                    Word word1 = null;
                    if(jsonObject.getBoolean("success")==true) {
                        word1 = new Word(jsonObject.getString("nameWord"),
                                jsonObject.getString("description"),
                                jsonObject.getInt("diff_cat")
                        );
                    }
                    
                   // new ScoreViewController(context).viewScore(word_f);
                    //new LoginAdminController(context).cofirmLogin(admin,password_f);
                    new InsertWordController(context).wordExist1(word1, word_f, description_f, id_f);
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
                parametros.put("nameWord",word_f);
                System.out.println("*** login admin parametros");
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsonArrayRequest);
        return ;
    }

    public void wordList(String URL, String nameCategory, String type){
        final String nameCategory_f= nameCategory;
        final String type_f = type;
        final StringRequest jsonArrayRequest = new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONArray jsonArray =null;
                try {
                    jsonArray= new JSONArray(response);
                    ArrayList arrayList= new ArrayList();
                    arrayList=null;
                    for (int j=0; j<jsonArray.length(); j++){
                        arrayList.add(j, jsonArray.getString(j));
                    }
                    new PlayController(context).wordPlay(arrayList);

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
                parametros.put("nameCategory",nameCategory_f);
                parametros.put("type",type_f);
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsonArrayRequest);
    }

}
