package com.BusinessLogic;

import android.content.Context;


import com.DataAcces.Models.User;
import com.DataAcces.Repositories.UserRepository;

public class SignInUserController {
    Context context;
    UserRepository userRepository;
    public SignInUserController(Context context) {
        this.context = context;
        this.userRepository=new UserRepository(context);
    }

    /**
     * Esta funcion registra un usuario en la applicacion, haciendo llamado a la clase UserRepository.
     * @param email email del usuario a registrar
     * @param password password del usuario a registar.
     * @return
     */
    public void singin(String email, String password, String password2){
        if(this.PasswordValidation(password, password2)&& this.EmailValidation(email)){
            User user = new User(email, password, 0);
            userRepository.create(user, "http://ahorcado1d.000webhostapp.com/insert_user.php");
            this.userExist1(email);
        }
    }

    private boolean PasswordValidation(String password, String password2){
        return password.equals(password2);
    }
    private boolean EmailValidation(String email){
        return email.contains("@");
    }
    private  void userExist1(String email){
        userRepository.getbyEmail("http://ahorcado1d.000webhostapp.com/get_user.php", email, null, 2);
    }
    public static void userExist (User user){

    }
}
