package com.packt.Controller;

import com.packt.domain.Uzytkownik;
import com.packt.domain.repository.impl.UserRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by WP on 16.04.2016.
 */

@Controller
public class RegisterController {

  //  @Autowired
    UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String Register()
    {


        return "Register";
    }
  @RequestMapping(value="register/add" , method = RequestMethod.POST)
  public String checkUser (@ModelAttribute("user") @Valid Uzytkownik user, BindingResult result,
                           HttpServletRequest request,Model model)
  {

      if(!user.getPassword().equals(request.getParameter("confirm_password")))
    {
      model.addAttribute("error","Passwords are different");
        return "redirect:/register";
    }
  if(userRepository.read(user.getName())!=null)
      {
          model.addAttribute("error","user with that login already exists");
          return "redirect:/register";

      }
      //System.out.println(student.toString());
     //  System.out.println(confirm_password);
       // userRepository.read(student.getName())
        userRepository.create(user);
        return "index" ;

    }
}
