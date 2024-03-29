package com.DataAcces.Repositories;

import android.content.Context;
import android.widget.Toast;

import com.DataAcces.Models.Category;
import com.DataAcces.Models.Difficulty;
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

public class DifficultyRepository {
    Difficulty difficulty;
    Context context;
    boolean ook;
    boolean respuesta;

    public DifficultyRepository(Context context) {
        this.context = context;
        this.difficulty= null;
        this.ook=false;
        this.respuesta = true;
    }

    /**
     *Esta funcion crea una nueva entrada en la tabla User de la base de datos remota.
     * @param difficulty EL modelo Difficulty que contiene los datos de la entrada.
     * @param URL  la URL del servidor donde se encuentra la base de datos example: http://192.162.1.3:80/Database/insertar.php
     */
    public void createDifficulty (Difficulty difficulty, String URL){
        final String  type =difficulty.getType();
        final String score= Integer.toString(difficulty.getScore());

        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonObject = new JSONObject(response);
                    ook = jsonObject.getBoolean("success");
                    if(ook){
                        Toast.makeText(context, "INSERCION EXITOSA",Toast.LENGTH_SHORT).show();
                    }

                }catch (JSONException e ) {
                    System.out.println("exeption    "+ e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Operacion fallida " + error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams()  {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("type", type );
                parametros.put("score", score);
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

    }
    public void delete (String type){}
    public void update (String tyepe, short score){}
    public void  getbyDifficulty(String URL){}
}
