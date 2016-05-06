package com.packt.domain.repository.impl;


import com.packt.domain.TrolloUsers;


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
        System.out.println(boardRepository.readOneBoard(trolloUsers,23).toString());
        boardRepository.finalize();

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
