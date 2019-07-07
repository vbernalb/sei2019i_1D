package com.BusinessLogic;

import android.content.Context;


import com.DataAcces.Models.User;
import com.DataAcces.Repositories.UserRepository;

public class SignInUserController {
    Context context;

    public SignInUserController(Context context) {
        this.context = context;
    }

    /**
     * Esta funcion registra un usuario en la applicacion, haciendo llamado a la clase UserRepository.
     * @param email email del usuario a registrar
     * @param password password del usuario a registar.
     * @return
     */
    public boolean singin(String email, String password, String password2){
        if(this.PasswordValidation(password, password2)&& this.EmailValidation(email)&& this.UserExist(email)){
            User user = new User(email, password, 0);
            UserRepository userRepository = new UserRepository(context);
            System.out.println("*******entre al sign in");
            userRepository.create(user, "http://ahorcado1d.000webhostapp.com/insert_user.php");
            return true;
        }
        else return false;
    }

    private boolean PasswordValidation(String password, String password2){
        return password.equals(password2);
    }
    private boolean EmailValidation(String email){
        return email.contains("@unal.edu.co")|| email.contains("@hotmail.com")||email.contains("@gmail.com")
                || email.contains("@outlook.com");
    }
    private boolean UserExist (String email){
        return true;
    }
}
