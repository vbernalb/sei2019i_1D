package com.BusinessLogic;

import android.content.Context;

public class LoginAdminController {
    Context context;

    public LoginAdminController(Context context) {
        this.context = context;
    }
    /**
     * Esta funcion loguea un administrador en la applicacion, haciendo llamado a la clase AdminRepository.
     * @param email email del administrador registrado
     * @param password password del administrador registrado.
     * @return
     */
    public boolean loginAdmin(String email, String password){
        return true;
    }
}
