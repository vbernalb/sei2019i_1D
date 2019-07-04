package com.BusinessLogic;

import android.content.Context;


import com.DataAcces.Models.User;
import com.DataAcces.Repositories.UserRepository;

public class SignInController {
    Context context;

    public boolean singin(String email, String password){
        User user = new User(email,password,0);
        UserRepository userRepository = new UserRepository (context);
        return userRepository.create(user,"http://ahorcado1d.000webhostapp.com/ahorcados/insert_user.php");
    }
}
