package com.BusinessLogic;

import android.content.Context;


import com.DataAcces.Models.User;
import com.DataAcces.Repositories.UserRepository;
import com.Presentation.RegisterActivity;

public class SignInUserController {
    final Context context;
    UserRepository userRepository;
    public SignInUserController(Context context) {
        this.context = context;
        this.userRepository=new UserRepository(context);
    }

    /**
     * Esta funcion verifica si los datos enviados cumplen con las normas de registro de la aplicacion, de ser asi luego
     * llama a userExist para verificar que el usuario exista o no.
     * @param email email del usuario a registrar
     * @param password password del usuario a registar.
     */
    public void singin(String email, String password, String password2){
        if(this.PasswordValidation(password, password2)&& this.EmailValidation(email)){
            this.userExist1(email, password);
        }

    }

    /**
     * Esta funcion verifica que la primera contraseña ingresada coinsida con la segunda contraseña, y que ambas posean de 6 a 18
     * caracteres.
     * @param password
     * @param password2
     * @return
     */
    private boolean PasswordValidation(String password, String password2){
        return password.equals(password2)&&(password.length()>=6)&&(password.length()<=18);
    }

    public static boolean PasswordValidationSignIn(String password, String password2){
        return password.equals(password2)&&(password.length()>=6&& password.length()<=18);
    }

    /**
     * Esta funcion verifica que el email ingresado posea un caracter '@".
     * @param email
     * @return
     */
    private boolean EmailValidation(String email){
        return email.contains("@");
    }

    public static boolean EmailValidationtest(String email){
        return email.contains("@");
    }

    /**
     * Esta funcion llama a UserRepository, para verificar si el usuario a registrar ya existe en la base de datos.
     * @param email
     * @param password
     */
    private void userExist1(String email, String password){
        userRepository.getbyEmail("http://ahorcado1d.000webhostapp.com/get_user.php", email, password, 2);
    }

    /**
     * Esta funcion toma la respuesta del repositorio, de no existir ya un usuario lo crea en la base de datos, y envia la respuesta
     * devuelta a la actividad. 
     * @param user
     * @param email
     * @param password
     */
    public void userExist (User user, String email, String password){
        boolean confirm =false;
        final RegisterActivity ma = (RegisterActivity) context;
            if(user==null){
                confirm= true;
                new UserRepository(context).create(new User(email,password,0),"http://ahorcado1d.000webhostapp.com/insert_user.php");
            }
        ma.nuevoIntent(confirm, context);
        }
}
