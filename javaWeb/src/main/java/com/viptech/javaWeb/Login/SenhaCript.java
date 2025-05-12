
package com.viptech.javaWeb.Login;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class SenhaCript {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaCriptografada = encoder.encode("1234");
        System.out.println(senhaCriptografada);
    }
}
