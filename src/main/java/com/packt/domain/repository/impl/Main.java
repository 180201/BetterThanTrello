package com.packt.domain.repository.impl;


import com.packt.domain.Trollo_users;

/**
 * Created by wp on 01.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        System.out.println(userRepository.read("TEST USER2").toString());
        userRepository.create(new Trollo_users());
    }
}
