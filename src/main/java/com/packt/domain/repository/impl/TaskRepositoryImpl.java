package com.packt.domain.repository.impl;

import com.packt.domain.Label;
import com.packt.domain.Task;
import com.packt.domain.TrolloColumn;
import com.packt.domain.TrolloUsers;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 * Created by wp on 22.05.2016.
 */
public class TaskRepositoryImpl implements TaskRepository  {


    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public TaskRepositoryImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("db");
        entityManager=entityManagerFactory.createEntityManager();
    }

    @Override
    protected void finalize() throws Throwable {

        entityManager.close();
        entityManagerFactory.close();
    }


    @Override
    public void createTask(TrolloColumn trolloColumn, Task trolloTask, TrolloUsers trolloUsers) {

        trolloTask.setTrolloColumn(trolloColumn);
        entityManager.getTransaction().begin();
        entityManager.persist(trolloTask);
        entityManager.getTransaction().commit();


    }

    @Override
    public List<Task> readAllTasks(TrolloColumn trolloColumn) {

        TypedQuery<Task> query = entityManager.createQuery("Select tc from Task tc where tc.trolloColumn =:trolloColumn order by orderTask",
                Task.class).setParameter("trolloColumn",trolloColumn);


        return query.getResultList();
    }

   @Override
    public Task readOneTask(long idTask) {
        TypedQuery<Task> query = entityManager.createQuery("Select tc from Task tc where tc.id =:TaskId",
                Task.class).setParameter("TaskId",idTask);

        return query.getSingleResult();

    }

    @Override
    public void update(long idTask, String titleTask) {

    }

    @Override
    public void updateLabel(long idTask, Label label) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("update Task tk set tk.labelInTask=:label " +
                "where tk.id=:idTask");
        query.setParameter("label", label);
        query.setParameter("idTask", idTask);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(long idTask) {

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE from Task tc where tc.id=:idTask");
        query.setParameter("idTask", idTask);
        query.executeUpdate();
        entityManager.getTransaction().commit();

    }

    @Override
    public void updateOrder(String orderTask) {
        TrolloColumn trolloColumn;
        PositionsTasksAndColumns positionsTasksAndColumns = new PositionsTasksAndColumns();
        List<PositionsTasksAndColumns.OrderTasks> listOrderTasks = positionsTasksAndColumns.generateOrderTasks(orderTask);
        for (int i=0;i<listOrderTasks.size();i++)
        {
            Date date = new Date(Calendar.getInstance().getTime().getTime());
            entityManager.getTransaction().begin();
            Query queryColumn = entityManager.createQuery("select tc from TrolloColumn tc  where " +
                    "tc.id=:idColumn ", TrolloColumn.class).setParameter("idColumn", listOrderTasks.get(i).getIdColumn());
            trolloColumn= (TrolloColumn) queryColumn.getSingleResult();

            Query query = entityManager.createQuery("UPDATE Task tk set tk.orderTask=:orderTask, tk.modyficationDate=:date, tk.trolloColumn=:trolloColumn " +
                    "where tk.id=:idTask");
            query.setParameter("orderTask", Long.parseLong(Integer.toString(i),10));
            query.setParameter("date",date);
            query.setParameter("trolloColumn",trolloColumn);
            query.setParameter("idTask", listOrderTasks.get(i).getIdTask());
            query.executeUpdate();
            entityManager.getTransaction().commit();

        }

    }
}
