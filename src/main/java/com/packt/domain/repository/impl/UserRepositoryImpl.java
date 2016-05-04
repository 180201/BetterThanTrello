package com.packt.domain.repository.impl;


import com.packt.domain.TrolloUsers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
    public void create(TrolloUsers user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }


    @Override
    public TrolloUsers read(String Login)
    {
        // zapytanie jpql

        //noinspection JpaQlInspection
        TrolloUsers trolloUsers=new TrolloUsers();
        TypedQuery<TrolloUsers> query = entityManager.createQuery("SELECT u FROM TrolloUsers u where u.name=:Login ", TrolloUsers.class);// key sensitive przy zapytaniu !!!
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
    public void update(long userId, TrolloUsers user) {

    }

    @Override
    public void delete(long UserId) {

    }
}
