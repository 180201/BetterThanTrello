package com.packt.domain.repository.impl;


import com.packt.domain.Uzytkownik;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

//@Repository
public class UserRepositoryImpl implements UserRepository
{
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public UserRepositoryImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("db");
        entityManager=entityManagerFactory.createEntityManager();

    }

    @Override
    protected void finalize() throws Throwable {

        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void create(Uzytkownik user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }


    @Override
    public Uzytkownik read(String Login)
    {
        // zapytanie jpql

        //noinspection JpaQlInspection
        Uzytkownik uzytkownik=new Uzytkownik();
        TypedQuery<Uzytkownik> query = entityManager.createQuery("SELECT u FROM Uzytkownik u where u.name=:Login ", Uzytkownik.class);// key sensitive przy zapytaniu !!!
        query.setParameter("Login",Login);
        try{
            uzytkownik=query.getSingleResult();
        }catch (Exception e)
        {
            //e.printStackTrace();
            uzytkownik = null;
        }
        return uzytkownik;
    }

    @Override
    public void update(long userId, Uzytkownik user) {

    }

    @Override
    public void delete(long UserId) {

    }
}
