package com.DataAcces.Repositories;

import android.content.Context;
import android.widget.Toast;

import com.BusinessLogic.LoginUserController;
import com.BusinessLogic.PlayController;
import com.BusinessLogic.ScoreViewController;
import com.BusinessLogic.SignInUserController;
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

public class UserRepository {

    User user;
    boolean ook;
    boolean respuesta;
    Context context;

    public UserRepository(Context context) {
        this.context = context;
        this.user=null;
        this.ook=false;
        this.respuesta = true;
    }


    /**
     *Esta funcion crea una nueva entrada en la tabla User de la base de datos remota.
     * @param user EL modelo usuario que contiene los datos de la entrada.
     * @param URL  la URL del servidor donde se encuentra la base de datos example: http://192.162.1.3:80/Database/insertar.php
     * @return si se realizo todo el proceso de comunicacion con la base de datos
     */
    public void create (User user, String URL){


        final String  email =user.getEmail_user();
        final String  password_user =user.getPassword_user();
        final String  acomulate_score =Integer.toString(user.getAcumulate_score());

        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try{
                    JSONObject jsonObject = new JSONObject(response);


                    if(jsonObject.getBoolean("success")){
                        Toast.makeText(context, "REGISTRO EXITOSO",Toast.LENGTH_SHORT).show();
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
                parametros.put("email_user",email);
                parametros.put("password_user",password_user);
                parametros.put("accumulated_score",acomulate_score);

                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);



            return ;

    }


    public void delete (String email_user){}
    public void update (String URL, String email_user, int score){
        final String email = email_user;
        final String score_f = Integer.toString(score);
        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try{
                    JSONObject jsonObject = new JSONObject(response);


                    if(jsonObject.getBoolean("success")){
                        //Toast.makeText(context, "REGISTRO EXITOSO",Toast.LENGTH_SHORT).show();
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
                parametros.put("email_user",email);
                parametros.put("accumulated_score",score_f);
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
        return ;
    }
    /**
     *Busca de acuerdo al parametro especificado en la URL
     * @param URL  la URL del servidor donde se encuentra la base de datos example: http://192.162.1.3:80/Database/insertar.php
     *@param email El email por el cual se quiere buscar
     *  @param password La contraseña por el cual se quiere comparar
     */
    public void getbyEmail(String URL, final String email, String password, int tipo ){
        final int numero = tipo;
        final String email_F = email;
        System.out.println("*** user entro");
        final String password_f = password;
        StringRequest jsonArrayRequest = new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                JSONObject jsonObject = null;
                System.out.println("*** llego respuesta");
                       try {
                        System.out.println("*** onResponse user ");
                        jsonObject = new JSONObject(response);
                           User user = null;
                        if(jsonObject.getBoolean("success")==true) {
                             user = new User(jsonObject.getString("email_user"),
                                    jsonObject.getString("password_user"),
                                    Integer.parseInt(jsonObject.getString("accumulated_score")));
                        }
                            switch (numero) {
                                case 1:
                                    new LoginUserController(context).cofirmLogin(user, password_f);
                                    break;
                                case 2:
                                    new SignInUserController(context).userExist(user, email_F, password_f);
                                    break;
                                case 3:
                                    new ScoreViewController(context).viewScoreAnswer(user.getAcumulate_score());
                                    break;
                            }
                    } catch (JSONException e) {
                        System.out.println("on error ");
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "problema en la conxion", Toast.LENGTH_SHORT).show();
            }
        }
        ){
            @Override
            protected Map<String, String> getParams()  {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("email_user",email_F);
                System.out.println("*** login admin parametros");
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsonArrayRequest);
        return ;
    }



}
