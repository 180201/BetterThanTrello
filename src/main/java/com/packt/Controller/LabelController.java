package com.packt.Controller;

import com.packt.domain.Label;
import com.packt.domain.Task;
import com.packt.domain.TrolloBoard;
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

/**
 * Created by Winiu on 24-06-2016.
 */
@Controller
@RequestMapping("/Dashboard/column/")
public class LabelController {
    TaskRepository taskRepository;
    BoardRepository boardRepository;
    LabelRepository labelRepository;

    @RequestMapping(value ="label/add", method = RequestMethod.POST)
    public String addBoard(@ModelAttribute("newLabel") @Valid Label newLabel, BindingResult result,
                           HttpServletRequest request, Model model){
        labelRepository= new LabelRepositoryImpl();
        HttpSession httpSession=request.getSession(true);
        TrolloBoard trolloBoard = (TrolloBoard) httpSession.getAttribute("board");
        Task task = (Task) httpSession.getAttribute("task");
            System.out.println(newLabel.toString());
        System.out.println(trolloBoard);
        labelRepository.create(newLabel,trolloBoard);

        return new String("redirect:/Dashboard/column/Task?idTask="+task.getId());
    }

    @RequestMapping(value = "label/addLabelTask", method = RequestMethod.GET)
    public String editColumn(@RequestParam("idLabel")String idLabel, HttpServletRequest request, Model model){
        labelRepository= new LabelRepositoryImpl();
        taskRepository= new TaskRepositoryImpl();
        HttpSession httpSession= request.getSession(true);
        Task task = (Task) httpSession.getAttribute("task");
        TrolloBoard trolloBoard= (TrolloBoard) httpSession.getAttribute("board");
        Label label= labelRepository.readOneLabel(Long.parseLong(idLabel, 10));
        taskRepository.updateLabel(task.getId(),label);
        System.out.println(task.toString());
        return new String("redirect:/Dashboard/column?idBoard="+trolloBoard.getId());
    }
    /*@RequestMapping(value = "label/add",method = RequestMethod.GET)
    public String addBoard*/
}
