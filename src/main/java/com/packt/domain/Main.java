package com.packt.domain;

import com.packt.domain.repository.impl.UserRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by WP on 30.03.2016.
 */
public class Main {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) throws ParseException {


         entityManagerFactory = Persistence.createEntityManagerFactory("db");
        entityManager=entityManagerFactory.createEntityManager();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = "2011-12-31 00:00:00";

        java.util.Date date = sdf.parse(strDate);

        java.sql.Date sqlDate = new Date(date.getTime());
        Uzytkownik uzytkownik1 =new Uzytkownik(sqlDate,sqlDate,2,3,"aaa","ggg","fff");

        UserRepositoryImpl userRepository= new UserRepositoryImpl();

        userRepository.create(uzytkownik1);

        System.out.println(userRepository.read(1L).getName());


//        entityManager.getTransaction().begin();
//        entityManager.persist(uzytkownik1);
//        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }


}

