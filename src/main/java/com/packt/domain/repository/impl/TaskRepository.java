package com.packt.domain.repository.impl;

import com.packt.domain.TrolloBoard;
import com.packt.domain.TrolloColumn;
import com.packt.domain.TrolloUsers;

import java.util.List;
import  com.packt.domain.Task;
/**
 * Created by wp on 22.05.2016.
 */
public interface TaskRepository {


    public void createTask(TrolloColumn trolloColumn, Task trolloTask, TrolloUsers trolloUsers);
    List<Task> readAllTasks(TrolloColumn trolloColumn);
    public Task readOneTask(long idTask);
    void update (long idTask, String titleTask);
    void delete (long idTask);
}
