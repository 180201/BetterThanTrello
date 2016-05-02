package com.packt.domain.repository.impl;

/**
 * Created by wp on 01.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        UserRepositoryImpl userRepository= new  UserRepositoryImpl();
        System.out.println(userRepository.read("test user").getName());

    }
}
