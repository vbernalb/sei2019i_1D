package com.BusinessLogic;

import android.content.Context;

import com.DataAcces.Models.Admin;
import com.DataAcces.Repositories.AdminRepository;
import com.Presentation.MainActivity;

public class LoginAdminController {
    final Context context;

    public LoginAdminController(Context context) {
        this.context = context;
    }

    /**
     * Esta funcion Verifica que los datos ingresados en la actividad coincidan con los datos de un admin,
     * llamando al AdminRepository.
     * @param email    email del administrador registrado
     * @param password password del administrador registrado.
     * @return
     */
    public void loginAdmin(String email, String password) {
        new AdminRepository(context).getbyEmail("http://ahorcado1d.000webhostapp.com/get_admi.php",email ,password);
    }

    /**
     * Esta funcion coge la respuesta enviada del repositorio, verifica que el admin exista y que la clave coincida,
     * y le envia la respuesta a la actividad.
     * @param admin
     * @param password
     */

    public void cofirmLogin(Admin admin, String password){
        boolean confirm = false;
        final MainActivity ma = (MainActivity) context;

        if(admin!= null){
            if(admin.getPassword_admi().equals(password))confirm = true;
        }
        ma.nuevoIntent(confirm, context);

    }

    /**
     * Esta funcion verifica que la clave ingresada coincida con la clave almacenada en la base de datos del administrador.
     * @param password1
     * @param password2
     * @return
     */
    public static boolean confirmLoginAdmin(String password1, String password2){
        return password1.equals(password2);
    }


}