package com.BusinessLogic;

import android.content.Context;

import com.DataAcces.Models.Admin;
import com.DataAcces.Repositories.AdminRepository;
import com.Presentation.MainActivity;

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
        new AdminRepository(context).getbyEmail("http://ahorcado1d.000webhostapp.com/get_admi.php",email ,password);
    }

    public static void cofirmLogin(Admin admin, String password){
        boolean confirm = false;
        if(admin!= null){
            if(admin.getPassword_admi().equals(password))confirm = true;

        };
        new MainActivity().nuevoIntent(confirm);

    }


}