import com.packt.domain.Task;
import com.packt.domain.TrolloBoard;
import com.packt.domain.TrolloColumn;
import com.packt.domain.TrolloUsers;
import com.packt.domain.repository.impl.*;

import javax.persistence.Column;
import java.util.List;

/**
 * Created by wp on 22.05.2016.
 */
public class TaskRepositoryTest {

    public static void main(String[] args) {

        TaskRepository taskRepository = new TaskRepositoryImpl();

        TrolloUsers users = new TrolloUsers();
        users.setName("Marian");
        TrolloBoard trolloBoard =new TrolloBoard();
        trolloBoard.setTitle("tres board");
        TrolloColumn trolloColumn = new TrolloColumn();
        trolloColumn.setTitle(" test column");

        new UserRepositoryImpl().create(users);
        new BoardRepositoryImpl().createBoard(trolloBoard,users);
        new ColumnRepositoryImpl().createColumn(trolloBoard,trolloColumn,users);


        Task task1= new Task();
        task1.setTitle("test task1");


        Task task2= new Task();
        task1.setTitle("test task2");

        Task task3= new Task();
        task1.setTitle("test task3");

        Task task4= new Task();
        task1.setTitle("test task4");


        TaskRepositoryImpl repository = new TaskRepositoryImpl();

        repository.createTask(trolloColumn,task1,users);
        repository.createTask(trolloColumn,task2,users);
        repository.createTask(trolloColumn,task3,users);
        repository.createTask(trolloColumn,task4,users);

        List<Task> taskList = repository.readAllTasks(trolloColumn);

        taskList.forEach(e-> System.out.println(e.toString()));


    }
}
