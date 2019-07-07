package com.BusinessLogic;

import android.content.Context;

import com.DataAcces.Models.User;
import com.DataAcces.Repositories.UserRepository;

public class LoginUserController {
    Context context;

    public LoginUserController(Context context) {
        this.context = context;
    }
    /**
     * Esta funcion loguea un usuario en la applicacion, haciendo llamado a la clase UserRepository.
     * @param email email del usuario registrado
     * @param password password del usuario registrado.
     * @return
     */
    public void loginAdmin(String email, String password) {
        new UserRepository(context).getbyEmail("http://ahorcado1d.000webhostapp.com/**.php",email ,password);
    }

    public boolean cofirmLogin(User user, String password){
        if(user!= null){
            if(user.getPassword_user().equals(password)) return true;
            return false;

        }
        return false;
    }
}
