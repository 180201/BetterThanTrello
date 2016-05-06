package com.packt.domain.repository.impl;

import com.packt.domain.TrolloBoard;
import com.packt.domain.TrolloUsers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
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
    public void update(long idBoard, TrolloBoard trolloBoard) {


    }

    @Override
    public void delete(long idBoard) {

    }
}
