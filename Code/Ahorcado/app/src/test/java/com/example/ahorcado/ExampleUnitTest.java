package com.example.ahorcado;

import com.BusinessLogic.LoginAdminController;
import com.BusinessLogic.LoginUserController;
import com.BusinessLogic.SignInUserController;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void email_contains_arroba() {
        assertTrue(SignInUserController.EmailValidationtest("valentina@hotmail.com"));
    }
    @Test
    public void password_equalsAdmin(){
        assertTrue(LoginAdminController.confirmLoginAdmin("123456","123456"));
    }
    @Test
    public void password_equalsUser(){
        assertTrue(LoginUserController.confirmLoginUser("123456","123456"));
    }
    @Test
    public void password_validationSignIn(){
        assertTrue(SignInUserController.PasswordValidationSignIn("123456","123456"));
    }
}