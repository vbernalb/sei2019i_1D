package com.DataAcces.Repositories;

import android.content.Context;

import com.DataAcces.Models.User;

public class UserRepository {

    Context context;

    /**
     *
     * @param user
     * @return
     */
    public boolean create (User user){return true;}
    public void delete (String email_user){}
    public void update (String email_user, short score){}

    public User getbyEmail(){
        return null;
    }
}
