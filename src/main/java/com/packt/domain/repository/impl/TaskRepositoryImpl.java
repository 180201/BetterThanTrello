package com.packt.domain.repository.impl;

import com.packt.domain.Task;
import com.packt.domain.TrolloBoard;
import com.packt.domain.TrolloColumn;
import com.packt.domain.TrolloUsers;

import javax.persistence.*;
import java.util.ArrayList;
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

        List<Task> trolloTasks = new ArrayList<Task>();
        TypedQuery<Task> query = entityManager.createQuery("Select tc from Task tc where tc.trolloColumn =:trolloColumn",
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
    public void delete(long idTask) {

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE from Task tc where tc.id=:idTask");
        query.setParameter("idTask", idTask);
        query.executeUpdate();
        entityManager.getTransaction().commit();

    }
}
