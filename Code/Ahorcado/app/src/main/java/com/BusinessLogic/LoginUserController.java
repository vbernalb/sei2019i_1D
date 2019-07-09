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
     * Esta funcion loguea un usuario en la applicacion, haciendo llamado a la clase UserRepository.
     * @param email email del usuario registrado
     * @param password password del usuario registrado.
     * @return
     */
    public void loginUser(String email, String password) {
        new UserRepository(context).getbyEmail("http://ahorcado1d.000webhostapp.com/get_user.php",email ,password,1);
    }

    public void cofirmLogin(User user, String password){
        boolean confirm = false;
        System.out.println("*** login admin confirm nuevo intend");
        final MainActivity ma = (MainActivity) context;

        if(user!= null){
            if(user.getPassword_user().equals(password))confirm = true;
            System.out.println("*** valor " + confirm);
        };
        ma.nuevoIntent2(confirm, context);
    }
}
