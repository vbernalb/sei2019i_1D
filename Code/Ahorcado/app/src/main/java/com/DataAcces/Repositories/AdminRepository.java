package com.DataAcces.Repositories;

import android.content.Context;
import android.widget.Toast;

import com.BusinessLogic.LoginAdminController;
import com.DataAcces.Models.Admin;
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

public class AdminRepository {

    public Context context;



    public AdminRepository(Context context) {
        this.context = context;

    }

    /**
     *Esta funcion crea una nueva entrada en la tabla User de la base de datos remota.
     * @param admin EL modelo admin que contiene los datos de la entrada.
     * @param URL  la URL del servidor donde se encuentra la base de datos example: http://192.162.1.3:80/Database/insertar.php
     * @return
     */

    
    public void create (Admin admin, String URL){
        System.out.println("*******entre al user repositori");
        boolean operacion= false;
        final String  email =admin.getEmail_admi();
        final String  password_user =admin.getPassword_admi();

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
                parametros.put("email_admin",email);
                parametros.put("password_admin",password_user);

                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


        return ;

    }

    /**
     * Busca de acuerdo al parametro especificado en la URL
     * @param URL  la URL del servidor donde se encuentra la base de datos example: http://192.162.1.3:80/Database/insertar.php
     * @param email El email por el cual se quiere buscar
     * @param password La contraseña por el cual se quiere comparar
     */
    public void getbyEmail(String URL,String email, String password){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        Admin admin= new Admin(jsonObject.getString("email_admin"),
                                jsonObject.getString("password_admin")
                               );
                            new LoginAdminController(context).cofirmLogin(admin,password);
                    } catch (JSONException e) {
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "problema en la conxion", Toast.LENGTH_SHORT).show();
            }
        }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsonArrayRequest);
        return ;
    }
}
