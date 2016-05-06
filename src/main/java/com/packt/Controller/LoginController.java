package com.packt.Controller;

import com.packt.domain.TrolloUsers;
import com.packt.domain.repository.impl.UserRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by WP on 16.04.2016.
 */
@Controller
public class LoginController {

   UserRepositoryImpl userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "Login";
    }

    @RequestMapping(value="login/chceck" , method = RequestMethod.POST)
            public String checkUser (@ModelAttribute("user") @Valid TrolloUsers user, BindingResult result, HttpServletRequest request)
             {
                 HttpSession httpSession=request.getSession(true);
                 userRepository = new UserRepositoryImpl();
                 boolean isValid;
                 System.out.println(user.getName()+" "+ user.getPassword());

                 TrolloUsers uzytkownik=  userRepository.read(user.getName());
                 System.out.println(uzytkownik.getName()+" "+uzytkownik.getPassword());
              if(uzytkownik==null||(uzytkownik.getPassword().equals(user.getPassword())!=true))
              {
                  isValid=false;
                  return "redirect:/login";
              }
                 else {

                  httpSession.setAttribute("User", uzytkownik);
                  return "redirect:/Dashboard";
              }


             }


}

