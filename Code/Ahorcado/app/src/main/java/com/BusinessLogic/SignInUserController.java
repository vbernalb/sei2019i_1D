package com.BusinessLogic;

import android.content.Context;


import com.DataAcces.Models.User;
import com.DataAcces.Repositories.UserRepository;
import com.Presentation.RegisterActivity;

public class SignInUserController {
    Context context;
    static boolean exist;
    UserRepository userRepository;
    public SignInUserController(Context context) {
        this.context = context;
        this.exist= false;
        this.userRepository=new UserRepository(context);
    }

    /**
     * Esta funcion registra un usuario en la applicacion, haciendo llamado a la clase UserRepository.
     * @param email email del usuario a registrar
     * @param password password del usuario a registar.
     * @return
     */
    private void singin(String email, String password, String password2){
        if(this.PasswordValidation(password, password2)&& this.EmailValidation(email)){
            this.userExist1(email, password);
        }

    }

    private boolean PasswordValidation(String password, String password2){
        return password.equals(password2);
    }
    private boolean EmailValidation(String email){
        return email.contains("@");
    }
    private void userExist1(String email, String password){
        userRepository.getbyEmail("http://ahorcado1d.000webhostapp.com/get_user.php", email, password, 2);
    }
    public void userExist (User user, String email, String password){
        final RegisterActivity ma = (RegisterActivity) context;
            if(user!= null){

                new UserRepository(context).create(new User(email,password,0),"http://ahorcado1d.000webhostapp.com/insert_user.php");
            }
        //ma.nuevoIntent(confirm, context);
        }
}
