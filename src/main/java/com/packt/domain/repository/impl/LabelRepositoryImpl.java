package com.packt.domain.repository.impl;

import com.packt.domain.Label;
import com.packt.domain.TrolloBoard;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Winiu on 24-06-2016.
 */
public class LabelRepositoryImpl implements LabelRepository {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public LabelRepositoryImpl()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("db");
        entityManager=entityManagerFactory.createEntityManager();
    }

    @Override
    protected void finalize() throws Throwable {

        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void create(Label label, TrolloBoard trolloBoard) {
        label.setTrolloBoardInLabel(trolloBoard);
        entityManager.getTransaction().begin();
        entityManager.persist(label);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Label> readAllLabel(TrolloBoard trolloBoard) {
        TypedQuery<Label> query = entityManager.createQuery("select lb from Label lb where " +
                "lb.trolloBoardInLabel=:trolloBoard", Label.class).setParameter("trolloBoard", trolloBoard);
        return query.getResultList();
    }

    @Override
    public Label readOneLabel(long idLabel) {
        TypedQuery<Label> query = entityManager.createQuery("select lb from Label lb where " +
                "lb.id=:idLabel", Label.class).setParameter("idLabel", idLabel);
        return query.getSingleResult();
    }

    @Override
    public void update(long idLabel, String color) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("update Label lb set lb.color=:color " +
                "where lb.id=:idLabel");
        query.setParameter("color", color);
        query.setParameter("idLabel", idLabel);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateName(long idLabel, String name) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("Update Label lb set lb.nameLabel=:name " +
                "where lb.id=:idLabel ");
        query.setParameter("name", name);
        query.setParameter("idLabel", idLabel);
        query.executeUpdate();
        entityManager.getTransaction().commit();

    }

    @Override
    public void delete(long idLabel) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE Label lb where" +
                " lb.id=:idLabel").setParameter("idLabel", idLabel);
        query.executeUpdate();
        entityManager.getTransaction().commit();

    }
}
