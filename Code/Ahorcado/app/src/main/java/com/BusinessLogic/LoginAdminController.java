package com.BusinessLogic;

import android.content.Context;

import com.DataAcces.Models.Admin;
import com.DataAcces.Repositories.AdminRepository;

public class LoginAdminController {
    Context context;

    public LoginAdminController(Context context) {
        this.context = context;
    }

    /**
     * Esta funcion loguea un administrador en la applicacion, haciendo llamado a la clase AdminRepository.
     *
     * @param email    email del administrador registrado
     * @param password password del administrador registrado.
     * @return
     */
    public void loginAdmin(String email, String password) {
        new AdminRepository(context).getbyEmail("http://ahorcado1d.000webhostapp.com/**.php",email ,password);
    }

    public boolean cofirmLogin(Admin admin){
        if(admin!= null)return true;
        return false;
    }


}