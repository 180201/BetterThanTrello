package com.packt.domain.repository.impl;

import com.packt.domain.Label;
import com.packt.domain.TrolloBoard;
import com.packt.domain.TrolloUsers;

/**
 * Created by Winiu on 22-06-2016.
 */
public class MyTest {
    public static void main(String[] args) {
        BoardRepository boardRepository = new BoardRepositoryImpl();
        LabelRepository labelRepository= new LabelRepositoryImpl();
        UserRepository userRepository = new UserRepositoryImpl();
        TaskRepository taskRepository = new TaskRepositoryImpl();
        TrolloUsers trolloUsers = userRepository.read("test");
        TrolloBoard trolloBoard = boardRepository.readOneBoard(trolloUsers,2);

        Label label;
        Label label2;

        label=labelRepository.readOneLabel(15);
        label2=labelRepository.readOneLabel(16);



        for (int i=6; i<12; i++)
        {

            if((i%2)==0)
            {
                taskRepository.updateLabel(i,label);
            }else{
                taskRepository.updateLabel(i,label2);
            }
        }




    }
}
