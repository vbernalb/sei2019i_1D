package com.BusinessLogic;

import android.content.Context;

import com.DataAcces.Models.User;
import com.DataAcces.Repositories.UserRepository;
import com.Presentation.MainActivity;

public class LoginUserController {
    Context context;

    public LoginUserController(Context context) {
        this.context = context;
    }
    /**
     * Esta funcion verifica que el usuario exista en la dase de datos, haciendo llamado a la clase UserRepository.
     * @param email email del usuario registrado
     * @param password password del usuario registrado.
     */
    public void loginUser(String email, String password) {
        new UserRepository(context).getbyEmail("http://ahorcado1d.000webhostapp.com/get_user.php",email ,password,1);
    }

    /**
     * Esta funcion toma la respuesta del repositorio, verifica que el user exista y su contraseña coincida, y
     * le envia la respuesta a la actividad.
     * @param user
     * @param password
     */
    public void cofirmLogin(User user, String password){
        boolean confirm = false;
        final MainActivity ma = (MainActivity) context;

        if(user!= null){
            if(user.getPassword_user().equals(password))confirm = true;
        };
        ma.nuevoIntent2(confirm, context);
    }

    /**
     * Esta funcion verifica que la contraseña ingresada y la contraseña guardada en la base de datos coincidan.
     * @param password1
     * @param password2
     * @return
     */
    public static boolean confirmLoginUser(String password1, String password2){
        return password1.equals(password2);
    }

}
