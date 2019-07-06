package com.BusinessLogic;

import android.content.Context;

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
    public boolean loginUser(String email, String password){
        return true;
    }
}
