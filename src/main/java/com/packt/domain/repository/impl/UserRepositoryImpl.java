package com.packt.domain.repository.impl;


import com.packt.domain.Trollo_users;
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
    public void create(Trollo_users user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }


    @Override
    public Trollo_users read(String Login)
    {
        // zapytanie jpql

        //noinspection JpaQlInspection
        Trollo_users trolloUsers=new Trollo_users();
        TypedQuery<Trollo_users> query = entityManager.createQuery("SELECT u FROM Trollo_users u where u.name=:Login ", Trollo_users.class);// key sensitive przy zapytaniu !!!
        query.setParameter("Login",Login);
        try{
            trolloUsers=query.getSingleResult();
        }catch (Exception e)
        {
            //e.printStackTrace();
            trolloUsers = null;
        }
        return trolloUsers;
    }

    @Override
    public void update(long userId, Trollo_users user) {

    }

    @Override
    public void delete(long UserId) {

    }
}
