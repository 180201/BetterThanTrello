package com.packt.domain.repository.impl;

import com.packt.domain.TrolloBoard;
import com.packt.domain.TrolloUsers;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Winiu on 05-05-2016.
 */
public class BoardRepositoryImpl implements BoardRepository {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public BoardRepositoryImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("db");
        entityManager=entityManagerFactory.createEntityManager();
    }

    @Override
    protected void finalize() throws Throwable {

        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void createBoard(TrolloBoard trolloBoard, TrolloUsers trolloUsers) {
        trolloBoard.setTrolloUsers(trolloUsers);
        entityManager.getTransaction().begin();
        entityManager.persist(trolloBoard);
        entityManager.getTransaction().commit();

    }

    @Override
    public List<TrolloBoard> readAllBoard(TrolloUsers trolloUsers) {

        System.out.println("Trollo Users in readAllBoard " + trolloUsers.toString());
        List<TrolloBoard> trolloBoards = new ArrayList<TrolloBoard>();
        TypedQuery<TrolloBoard> query = entityManager.createQuery("select b from TrolloBoard b where b.trolloUsers=:idBoard",
                TrolloBoard.class).setParameter("idBoard",trolloUsers);

        trolloBoards= query.getResultList();
        System.out.println(trolloBoards.size());


        return trolloBoards;
    }

    @Override
    public TrolloBoard readOneBoard(TrolloUsers trolloUsers, long idBoard) {
        TrolloBoard trolloBoard;
        TypedQuery<TrolloBoard> query = entityManager.createQuery("select b from TrolloBoard b where b.trolloUsers=:trolloUser and b.id=:idBoard",
                TrolloBoard.class).setParameter("trolloUser",trolloUsers);
        query.setParameter("idBoard",idBoard);

        trolloBoard= query.getSingleResult();


        return trolloBoard;
    }


    @Override
    public void update(long idBoard, String titleBoard) {
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("update TrolloBoard tb set tb.title=:titleBoard, tb.modificationDate=:date where tb.id=:idBoard ");
        query.setParameter("titleBoard", titleBoard);
        query.setParameter("idBoard", idBoard);
        query.setParameter("date",date);
        query.executeUpdate();
        entityManager.getTransaction().commit();


    }

    @Override
    public void delete(long idBoard) {

    }
}
