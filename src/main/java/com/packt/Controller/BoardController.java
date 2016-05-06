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

    @RequestMapping(value = "Dashboard", method = RequestMethod.GET)
    public String dashboard( HttpServletRequest request, Model model){
        HttpSession httpSession = request.getSession(true);
        TrolloUsers trolloUsers = (TrolloUsers) httpSession.getAttribute("User");

        System.out.println(trolloUsers.toString());
        boardRepository = new BoardRepositoryImpl();
        List<TrolloBoard> trolloBoards = boardRepository.readAllBoard(trolloUsers);
        System.out.println(trolloBoards.size());
        model.addAttribute("trolloBoards", trolloBoards);
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


}
