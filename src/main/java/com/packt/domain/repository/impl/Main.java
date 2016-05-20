package com.packt.domain.repository.impl;


import com.packt.domain.TrolloBoard;
import com.packt.domain.TrolloColumn;
import com.packt.domain.TrolloUsers;

import java.util.List;


/**
 * Created by wp on 01.05.2016.
 */
public class Main {
    public static void main(String[] args) throws Throwable {
        UserRepositoryImpl userRepository = new UserRepositoryImpl();



        TrolloUsers trolloUsers = userRepository.read("mateusz");
        System.out.println(trolloUsers.getTrolloBoards().toString());
        System.out.println(trolloUsers.toString());
        userRepository.finalize();

        String title = new String("Inny tytul");
        BoardRepositoryImpl boardRepository= new BoardRepositoryImpl();
        boardRepository.update(23, title);
        TrolloBoard trolloBoard = boardRepository.readOneBoard(trolloUsers,23);
        System.out.println(boardRepository.readOneBoard(trolloUsers,23).toString());
        ColumnRepositoryImpl columnRepository = new ColumnRepositoryImpl();
       /* TrolloColumn trolloColumn= new TrolloColumn();
        trolloColumn.setTitle("Nowa kolumna2");
        trolloColumn.setCreatingDate(new Date(Calendar.getInstance().getTime().getTime()));
        trolloColumn.setModyficationDate(new Date(Calendar.getInstance().getTime().getTime()));

        columnRepository.createColumn(trolloBoard,trolloColumn,trolloUsers);*/

        List<TrolloColumn> trolloColumns = columnRepository.readAllColumn(trolloBoard);
        System.out.println(trolloColumns.size());
        /*columnRepository.update(31,"NOWY LEPSZY TYTUL");
        columnRepository.delete(31);*/
        System.out.println(columnRepository.readOneColumn(trolloBoard,32L).toString());

        /*columnRepository.finalize();
        boardRepository.finalize();*/

        /*BoardRepositoryImpl boardRepository = new BoardRepositoryImpl();
        List<TrolloBoard> trolloBoardSet = boardRepository.readAllBoard(trolloUsers);
        System.out.println(trolloBoardSet.size());
        boardRepository.finalize();*/

     /*   EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();*/


/*
        entityManager.persist(new TrolloBoard(new Long("1"),new Long("1"),new Long("1"),
                new Date(Calendar.getInstance().getTime().getTime()),
                new Date(Calendar.getInstance().getTime().getTime()),"My Board","This is my Board",trolloUsers,new Long("123")));

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();*/
      //  System.out.println(userRepository.read("mateusz").toString());
       // userRepository.create(new TrolloUsers());
    }
}
