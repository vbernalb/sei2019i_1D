package com.BusinessLogic;

import android.content.Context;
import android.widget.Toast;


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
     * Esta funcion registra un usuario en la applicacion, haciendo llamado a la clase UserRepository.
     * @param email email del usuario a registrar
     * @param password password del usuario a registar.
     * @return
     */
    public void singin(String email, String password, String password2){
        if(this.PasswordValidation(password, password2)&& this.EmailValidation(email)){
            this.userExist1(email, password);
        }

    }


    private boolean PasswordValidation(String password, String password2){
        final RegisterActivity ma = (RegisterActivity) context;
        if(password.equals(password2)){
            if(password.length()>=6){
                if(password.length()<=18) {
                    return password.equals(password2) && (password.length() >= 6) && (password.length() <= 18);
                }else{
                    Toast.makeText(ma,"La contraseña debe ser menor de 19 caracteres", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }else{
                Toast.makeText(ma,"La contraseña debe ser mayor o igual a 6 carácteres", Toast.LENGTH_SHORT).show();
                return false;
            }
        }else{
            Toast.makeText(ma,"Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public static boolean PasswordValidationSignIn(String password, String password2){
        return password.equals(password2)&&(password.length()>=6&& password.length()<=18);
    }

    private boolean EmailValidation(String email){
        final RegisterActivity ma = (RegisterActivity) context;
        if (email.contains("@")){
            return email.contains("@");
        }else{
            Toast.makeText(ma,"El correo no es correcto", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    public static boolean EmailValidationtest(String email){
        return email.contains("@");
    }

    private void userExist1(String email, String password){
        userRepository.getbyEmail("http://ahorcado1d.000webhostapp.com/get_user.php", email, password, 2);
    }
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
