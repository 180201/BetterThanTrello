package com.packt.Controller;

import com.packt.domain.*;
import com.packt.domain.repository.impl.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by wp on 22.05.2016.
 */

@Controller
@RequestMapping("/Dashboard/column")
public class TaskController {

    TaskRepository taskRepository;
    ColumnRepository columnRepository;
    LabelRepository labelRepository;
    @RequestMapping(value = "/Task", method = RequestMethod.GET)
    public String Task(@RequestParam("idTask")String idTask, HttpServletRequest request, Model model){

        taskRepository = new TaskRepositoryImpl();
        labelRepository = new LabelRepositoryImpl();

        HttpSession httpSession=request.getSession(true);

        TrolloUsers trolloUser = (TrolloUsers) httpSession.getAttribute("User");
        TrolloBoard trolloBoard = (TrolloBoard) httpSession.getAttribute("board");


        Task task=taskRepository.readOneTask(Long.parseLong(idTask));
        LabelRepository labelRepository = new LabelRepositoryImpl();
        List<Label> labelList = labelRepository.readAllLabel(trolloBoard);
        Label label= labelList.get(0);

        model.addAttribute("task",task);
        model.addAttribute("labelList", labelList);
       httpSession.setAttribute("task",task);

        return "TaskOwerview";

    }
    @RequestMapping(value = "/Task/add", method = RequestMethod.GET)
    public String AddTask(@RequestParam ("column") String column,Model model,  HttpServletRequest request) {
        System.out.println("Add Task ");

        HttpSession httpSession = request.getSession(true);

        httpSession.setAttribute("columnid",column);
        String columnid= (String) httpSession.getAttribute("columnid");
        return "AddTask";
    }


    @RequestMapping(value = "/Task/delete", method = RequestMethod.GET)
    public String DeleteTask(@RequestParam ("idTask") String TaskId,HttpServletRequest request) {

        HttpSession httpSession = request.getSession(true);
        taskRepository=new TaskRepositoryImpl();
        TrolloBoard trolloBoard = (TrolloBoard) httpSession.getAttribute("board");
        taskRepository.delete(Long.parseLong(TaskId));


   return new String("redirect:/Dashboard/column?idBoard=" + trolloBoard.getId());
    }



    @RequestMapping(value = "/Task/add", method = RequestMethod.POST)
    public String AddTask(@ModelAttribute("Task") @Valid Task task, BindingResult result,
                          HttpServletRequest request, Model model) {


        HttpSession httpSession = request.getSession(true);

        taskRepository = new TaskRepositoryImpl();
        columnRepository=new ColumnRepositoryImpl();
       String columnid= request.getParameter("columnid");
        TrolloUsers trolloUsers = (TrolloUsers) httpSession.getAttribute("User");
        TrolloBoard trolloBoard = (TrolloBoard) httpSession.getAttribute("board");
        task.setOrderTask(99999l);
         TrolloColumn trollocolumn = columnRepository.readOneColumn(trolloBoard,Long.parseLong((String)httpSession.getAttribute("columnid")));

        taskRepository.createTask(trollocolumn,task,trolloUsers);

        return new String("redirect:/Dashboard/column?idBoard=" + trolloBoard.getId());


    }

}
