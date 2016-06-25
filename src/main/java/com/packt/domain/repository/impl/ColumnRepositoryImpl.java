package com.packt.domain.repository.impl;

import com.packt.domain.TrolloBoard;
import com.packt.domain.TrolloColumn;
import com.packt.domain.TrolloUsers;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Winiu on 20-05-2016.
 */
public class ColumnRepositoryImpl implements ColumnRepository {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public ColumnRepositoryImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("db");
        entityManager=entityManagerFactory.createEntityManager();
    }

    @Override
    protected void finalize() throws Throwable {

        entityManager.close();
        entityManagerFactory.close();
    }
    @Override
    public void createColumn(TrolloBoard trolloBoard, TrolloColumn trolloColumn, TrolloUsers trolloUsers) {
        trolloColumn.setTrolloBoardoInColumn(trolloBoard);
        trolloColumn.setTrolloUsersInColumn(trolloUsers);
        entityManager.getTransaction().begin();
        entityManager.persist(trolloColumn);
        entityManager.getTransaction().commit();

    }

    @Override
    public List<TrolloColumn> readAllColumn(TrolloBoard trolloBoard) {

        List<TrolloColumn> trolloColumns = new ArrayList<TrolloColumn>();
        TypedQuery<TrolloColumn> query = entityManager.createQuery("Select tc from TrolloColumn tc where tc.trolloBoardoInColumn=:trolloBoard order by orderColumn",
                TrolloColumn.class).setParameter("trolloBoard",trolloBoard);

        trolloColumns=query.getResultList();
        return trolloColumns;
    }

    @Override
    public TrolloColumn readOneColumn(TrolloBoard trolloBoard, long idColumn) {

        TrolloColumn trolloColumn;

        Query query = entityManager.createQuery("select tc from TrolloColumn tc where tc.trolloBoardoInColumn=:trolloBoard and tc.id=:idColumn",
                TrolloColumn.class);
        query.setParameter("trolloBoard", trolloBoard);
        query.setParameter("idColumn", idColumn);

        trolloColumn = (TrolloColumn) query.getSingleResult();

        return trolloColumn;
    }

    @Override
    public TrolloColumn readOneColumn(long idColumn) {

        TrolloColumn trolloColumn;

        Query query = entityManager.createQuery("select tc from TrolloColumn tc where tc.id=:idColumn",
                TrolloColumn.class);
        query.setParameter("idColumn", idColumn);

        trolloColumn = (TrolloColumn) query.getSingleResult();

        return trolloColumn;
    }

    @Override
    public void update(long idColumn, String titleColumn) {
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE TrolloColumn tc set tc.title=:titleColumn, tc.modyficationDate=:date " +
                "where tc.id=:idColumn");
        query.setParameter("idColumn", idColumn);
        query.setParameter("titleColumn", titleColumn);
        query.setParameter("date", date);
        query.executeUpdate();
        entityManager.getTransaction().commit();

    }

    @Override
    public void delete(long idColumn) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE from TrolloColumn tc where tc.id=:idColumn");
        query.setParameter("idColumn", idColumn);
        query.executeUpdate();
        entityManager.getTransaction().commit();

    }

    @Override
    public void updateOrder(String orderListFromView) {

        System.out.println(orderListFromView);
        PositionsTasksAndColumns positionsTasksAndColumns = new PositionsTasksAndColumns();
        long[] orderColumn = positionsTasksAndColumns.generateOrderColumn(orderListFromView);

        for (int i =0; i<orderColumn.length;i++)
        {
            System.out.println(i+ " "+orderColumn[i]);
            Date date = new Date(Calendar.getInstance().getTime().getTime());
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("UPDATE TrolloColumn tc set tc.orderColumn=:orderColumn, tc.modyficationDate=:date " +
                    "where tc.id=:idColumn");
            query.setParameter("idColumn", orderColumn[i]);
            query.setParameter("orderColumn", Long.parseLong(Integer.toString(i),10));
            query.setParameter("date", date);
            query.executeUpdate();
            entityManager.getTransaction().commit();
            System.out.println("Update column order "+orderColumn[i] );
        }


    }



}
