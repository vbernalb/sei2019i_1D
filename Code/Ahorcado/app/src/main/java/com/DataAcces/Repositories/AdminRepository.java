package com.DataAcces.Repositories;

import android.content.Context;
import android.widget.Toast;

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
    public Admin admin;

    public boolean create (Admin admin, String URL, Response.Listener<String> listener, Response.ErrorListener errorListener){
        final String  email =admin.getEmail_admi();
        final String  password_user =admin.getPassword_admi();


        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL,listener ,errorListener)
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("email_user",email);
                parametros.put("password_user",password_user);

                return super.getParams();
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
        return true;
    }
    public User getbyEmail(String URL, String email){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        admin= new Admin(jsonObject.getString("email_admin"),
                                jsonObject.getString("password_admin")
                               );

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

        return admin;
    }
}
