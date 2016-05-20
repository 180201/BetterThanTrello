package com.packt.Controller;

import com.packt.domain.TrolloBoard;
import com.packt.domain.TrolloUsers;
import com.packt.domain.repository.impl.BoardRepository;
import com.packt.domain.repository.impl.BoardRepositoryImpl;
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
import java.util.List;

/**
 * Created by Winiu on 05-05-2016.
 */
@Controller
public class BoardController {

    BoardRepository boardRepository;

    @RequestMapping(value = "/Dashboard", method = RequestMethod.GET)
    public String dashboard( HttpServletRequest request, Model model){
        HttpSession httpSession = request.getSession(true);
        TrolloUsers trolloUsers = (TrolloUsers) httpSession.getAttribute("User");

        boardRepository = new BoardRepositoryImpl();
        if(boardRepository.readAllBoard(trolloUsers).size()!=0)
        {
            List<TrolloBoard> trolloBoards = boardRepository.readAllBoard(trolloUsers);
            System.out.println(trolloBoards.size());
            model.addAttribute("trolloBoards", trolloBoards);
        }
        return "Dashboard";
    }

    @RequestMapping(value ="Dashboard/add", method = RequestMethod.POST)
    public String addBoard(@ModelAttribute("newBoard") @Valid TrolloBoard newBoard, BindingResult result,
                           HttpServletRequest request, Model model){
        HttpSession httpSession=request.getSession(true);

        boardRepository=new BoardRepositoryImpl();

        TrolloUsers trolloUsers = (TrolloUsers) httpSession.getAttribute("User");

        newBoard.setCreatingDate(new Date(Calendar.getInstance().getTime().getTime()));
        newBoard.setModificationDate(new Date(Calendar.getInstance().getTime().getTime()));
        boardRepository.createBoard(newBoard,trolloUsers);


        return "redirect:/Dashboard";
    }
    @RequestMapping(value ="/Dashboard/editboard", method = RequestMethod.GET)
    public String setAttributesBoardForEditing(@RequestParam("idBoard")String idBoard,HttpServletRequest request, Model model){
        HttpSession httpSession=request.getSession(true);
        TrolloUsers trolloUser = (TrolloUsers) httpSession.getAttribute("User");

        boardRepository=new BoardRepositoryImpl();
        TrolloBoard trolloBoard = boardRepository.readOneBoard(trolloUser,Long.parseLong(idBoard, 10));
        model.addAttribute("idBoard", trolloBoard.getId());
        model.addAttribute("title", trolloBoard.getTitle());

        return "editboard";
    }

    @RequestMapping(value ="/Dashboard/editboard", method = RequestMethod.POST)
    public String updateBoard(@ModelAttribute("editBoard") @Valid TrolloBoard editBoard, BindingResult result,
                              HttpServletRequest request, Model model) {
        HttpSession httpSession = request.getSession(true);
        TrolloUsers trolloUser = (TrolloUsers) httpSession.getAttribute("User");


        boardRepository = new BoardRepositoryImpl();
        boardRepository.update(editBoard.getId(), editBoard.getTitle());
        System.out.println(boardRepository.readOneBoard(trolloUser,editBoard.getId()).toString());
        return "redirect:/Dashboard";

    }

    @RequestMapping(value = "Dashboard/deleteboard", method = RequestMethod.GET)
    public String setAttributeBoardForDelete(@RequestParam("idBoard")String idBoard,HttpServletRequest request, Model model){
        HttpSession httpSession=request.getSession(true);
        TrolloUsers trolloUser = (TrolloUsers) httpSession.getAttribute("User");

        boardRepository=new BoardRepositoryImpl();
        TrolloBoard trolloBoard = boardRepository.readOneBoard(trolloUser,Long.parseLong(idBoard, 10));
        model.addAttribute("idBoard", trolloBoard.getId());
        model.addAttribute("title", trolloBoard.getTitle());
        return "deleteboard";
    }

    @RequestMapping(value = "/Dashboard/deleteboard",method = RequestMethod.DELETE)
    public String deleteBoard(@ModelAttribute("deleteBoard") @Valid TrolloBoard deleteBoard, BindingResult result,
                              HttpServletRequest request, Model model) {
        HttpSession httpSession = request.getSession(true);
        TrolloUsers trolloUser = (TrolloUsers) httpSession.getAttribute("User");


        boardRepository = new BoardRepositoryImpl();
        boardRepository.delete(deleteBoard.getId());
        //System.out.println(boardRepository.readOneBoard(trolloUser, deleteBoard.getId()).toString());
        return "redirect:/Dashboard";
    }

}
