package com.btg.PetSpringApi.utils;

public class Validor {

    public static Boolean passwordValidate(String password){
        return password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*\\W).{8,}$");
    }

    public static Boolean emailValidate(String email){
        return email.matches("^\\S{3,}@\\w{2,}\\.[a-zA-Z]{2,}$");
    }

}
