package com.packt.Controller;

import com.packt.domain.Task;
import com.packt.domain.TrolloBoard;
import com.packt.domain.TrolloColumn;
import com.packt.domain.TrolloUsers;
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
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Winiu on 20-05-2016.
 */
@Controller
@RequestMapping("/Dashboard")
public class ColumnController {
    ColumnRepository columnRepository;
    BoardRepository boardRepository;
    TaskRepository taskRepository;

    @RequestMapping(value = "/column", method = RequestMethod.GET)

    public String columns(@RequestParam("idBoard")String idBoard, HttpServletRequest request, Model model){
        HttpSession httpSession=request.getSession(true);
        TrolloUsers trolloUser = (TrolloUsers) httpSession.getAttribute("User");

        columnRepository = new ColumnRepositoryImpl();
        boardRepository = new BoardRepositoryImpl();
        taskRepository = new TaskRepositoryImpl();

        TrolloBoard trolloBoard =  boardRepository.readOneBoard(trolloUser,Long.parseLong(idBoard, 10));

         List<TrolloColumn> columnList = columnRepository.readAllColumn(trolloBoard);

        Map<TrolloColumn,List<Task>> map = new HashMap<TrolloColumn, List<Task>>();


        for (TrolloColumn column: columnList) {
            List<Task> taskList = taskRepository.readAllTasks(column);
           map.put(column,taskList);

        }

        if(columnList!=null)
        {
            model.addAttribute("mapt",map);
            httpSession.setAttribute("board",trolloBoard );
        }






        return "column";
    }

    @RequestMapping(value = "/column/add", method = RequestMethod.POST)
    public String addColumn(@ModelAttribute("newColumn") @Valid TrolloColumn newColumn, BindingResult result,
                            HttpServletRequest request, Model model){
        HttpSession httpSession=request.getSession(true);

        boardRepository=new BoardRepositoryImpl();

        TrolloUsers trolloUsers = (TrolloUsers) httpSession.getAttribute("User");
        TrolloBoard trolloBoard = (TrolloBoard) httpSession.getAttribute("board");

        newColumn.setCreatingDate(new Date(Calendar.getInstance().getTime().getTime()));
        newColumn.setModyficationDate(new Date(Calendar.getInstance().getTime().getTime()));
        columnRepository.createColumn(trolloBoard,newColumn,trolloUsers);
        return new String("redirect:/Dashboard/column?idBoard="+trolloBoard.getId()) ;
    }

    @RequestMapping(value = "/column/editcolumn", method = RequestMethod.GET)
    public String editColumn(@RequestParam("idColumn")String idColumn,HttpServletRequest request, Model model){
        HttpSession httpSession=request.getSession(true);
        TrolloBoard trolloBoard = (TrolloBoard) httpSession.getAttribute("board");

        columnRepository= new ColumnRepositoryImpl();
        System.out.println(trolloBoard.toString());
        TrolloColumn trolloColumn = columnRepository.readOneColumn(trolloBoard,Long.parseLong(idColumn, 10));

        System.out.println(trolloColumn.toString());
        model.addAttribute("idColumn", trolloColumn.getId());
        model.addAttribute("titleColumn", trolloColumn.getTitle());
        System.out.println(trolloColumn.getId() + trolloColumn.getTitle());
        return "editcolumn";
    }

    @RequestMapping(value ="/column/editcolumn", method = RequestMethod.POST)
    public String updateBoard(@ModelAttribute("editColumn") @Valid TrolloColumn editColumn, BindingResult result,
                              HttpServletRequest request, Model model) {
        HttpSession httpSession = request.getSession(true);
        TrolloUsers trolloUser = (TrolloUsers) httpSession.getAttribute("User");
        TrolloBoard trolloBoard= (TrolloBoard) httpSession.getAttribute("board");

        columnRepository = new ColumnRepositoryImpl();


        columnRepository.update(editColumn.getId(),editColumn.getTitle());


        return new String("redirect:/Dashboard/column?idBoard="+trolloBoard.getId());

    }

    @RequestMapping(value = "/column/deletecolumn", method = RequestMethod.GET)
    public String setAttributeBoardForDelete(@RequestParam("idColumn")String idColumn,HttpServletRequest request, Model model){
        HttpSession httpSession=request.getSession(true);
        TrolloBoard trolloBoard = (TrolloBoard) httpSession.getAttribute("board");

        columnRepository= new ColumnRepositoryImpl();

        TrolloColumn trolloColumn = columnRepository.readOneColumn(trolloBoard,Long.parseLong(idColumn, 10));

        System.out.println(trolloColumn.toString());
        model.addAttribute("idColumnDelete", trolloColumn.getId());
        model.addAttribute("titleColumnDelete", trolloColumn.getTitle());
        model.addAttribute("idBoard", trolloBoard.getId());
        System.out.println(trolloColumn.getId() + trolloColumn.getTitle());
        return "deletecolumn";
    }

    @RequestMapping(value = "/column/deletecolumn",method = RequestMethod.DELETE)
    public String deleteBoard(@ModelAttribute("deleteColumn") @Valid TrolloBoard deleteColumn, BindingResult result,
                              HttpServletRequest request, Model model) {
        HttpSession httpSession = request.getSession(true);
        columnRepository = new ColumnRepositoryImpl();
        TrolloUsers trolloUser = (TrolloUsers) httpSession.getAttribute("User");
        TrolloBoard trolloBoard= (TrolloBoard) httpSession.getAttribute("board");

        columnRepository.delete(deleteColumn.getId());


        return new String("redirect:/Dashboard/column?idBoard="+trolloBoard.getId());
    }
}
