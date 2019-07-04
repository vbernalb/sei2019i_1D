package com.BusinessLogic;

import android.content.Context;


import com.DataAcces.Models.User;
import com.DataAcces.Repositories.UserRepository;

public class SignInUserController {
    Context context;

    /**
     * Esta funcion registra un usuario en la applicacion, haciendo llamado a la clase UserRepository.
     * @param email email del usuario a registrar
     * @param password password del usuario a registar.
     * @return
     */
    public boolean singin(String email, String password){
        User user = new User(email,password,0);
        UserRepository userRepository = new UserRepository (context);
        return userRepository.create(user,"http://ahorcado1d.000webhostapp.com/ahorcados/insert_user.php");
    }
}
