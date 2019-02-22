package com.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestPwd {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        //123
        //$2a$10$1EaP6GZ1gAp1LLKEIY2oH.xX.oEV.ipVIbVvvesqDAsBq4/TlDkWa
        //$2a$10$qJ1GaAy.FyA4FTh9PMlyUu1W65wbmxxHjHVHs7FfspM.1Dz5Pus3O
        //456
        //$2a$10$n1ejycFyUrZoqhjvLMQI6OTBcJjBPir22N5SCeSE/ecrsa3Lsoi2u
        //$2a$10$W9ufIcaJ7vdNcbXGGs64quccSlbWgywbVBoZXoQM719.kOjRgoB5y
        String pwd= passwordEncoder.encode("abc");


        System.out.println(pwd.length());
    }
}
