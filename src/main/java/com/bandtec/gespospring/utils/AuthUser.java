package com.bandtec.gespospring.utils;

public class AuthUser {

    private static String nomeCerto = "matheushuk@gmail.com";
    private static String senhaCerta = "123456";

    public static String autenticate(String email, String senha){
        if(email.equals(nomeCerto) && senha.equals(senhaCerta)) return "Logado";
        if(email.equals(nomeCerto)) return "Senha incorreta";
        return "Email não cadastrado";
    }

}
