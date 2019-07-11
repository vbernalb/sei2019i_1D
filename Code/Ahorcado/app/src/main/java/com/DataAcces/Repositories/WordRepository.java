package com.DataAcces.Repositories;

import android.content.Context;
import android.widget.Toast;

import com.BusinessLogic.InsertWordController;
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
    public void getbyword(String URL,String word,String description, String categoria, String dificultad){
        final String word_f = word;
        final String description_f = description;
        final String categoria_f = categoria;
        final String dificultad_f = dificultad;
        StringRequest jsonArrayRequest = new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("*** login admin on repose ");
                JSONObject jsonObject = null;

                try {
                    System.out.println("*** login admin *** on repose");
                    jsonObject = new JSONObject(response);
                    Word word1 = null;
                    if(jsonObject.getBoolean("success")==true) {
                        word1 = new Word(jsonObject.getString("nameWord"),
                                jsonObject.getString("description")
                        );
                    }
                    
                   // new ScoreViewController(context).viewScore(word_f);
                    //new LoginAdminController(context).cofirmLogin(admin,password_f);
                    new InsertWordController(context).wordExist1(word1, word_f, description_f, categoria_f, dificultad_f);
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
}
