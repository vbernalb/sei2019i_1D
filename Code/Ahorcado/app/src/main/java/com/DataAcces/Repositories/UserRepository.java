package com.DataAcces.Repositories;

import android.content.Context;
import android.widget.Toast;

import com.DataAcces.Models.User;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    Context context;

    public UserRepository(Context context) {
        this.context = context;
    }

    /**
     *Esta funcion crea una nueva entrada en la tabla User de la base de datos remota.
     * @param user EL modelo usuario que contiene los datos de la entrada.
     * @param URL  la URL del servidor donde se encuentra la base de datos example: http://192.162.1.3:80/Database/insertar.php
     * @return si se realizo todo el proceso de comunicacion con la base de datos
     */
    public boolean create (User user, String URL){
        final String  email =user.getEmail_user();
        final String  password_user =user.getPassword_user();
        final String  acomulate_score =Integer.toString(user.getAcumulate_score());

        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, "Operacion exitosa",Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Operacion fallida",Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("email_user",email);
                parametros.put("password_user",password_user);
                parametros.put("acumulate_score",acomulate_score);

                return super.getParams();
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
            return true;
    }


    
    public void delete (String email_user){}
    public void update (String email_user, short score){}

    public User getbyEmail(){
        return null;
    }
}
