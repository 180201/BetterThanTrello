package com.packt.domain.repository.impl;

import com.packt.domain.Label;
import com.packt.domain.Task;
import com.packt.domain.TrolloColumn;
import com.packt.domain.TrolloUsers;

import java.util.List;
/**
 * Created by wp on 22.05.2016.
 */
public interface TaskRepository {


    public void createTask(TrolloColumn trolloColumn, Task trolloTask, TrolloUsers trolloUsers);
    List<Task> readAllTasks(TrolloColumn trolloColumn);
    public Task readOneTask(long idTask);
    void update (long idTask, String titleTask);
    void updateLabel(long idTask, Label label);
    void delete (long idTask);
    void updateOrder(String orderTask);
}
