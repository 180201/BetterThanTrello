package com.packt.Controller;

import com.packt.domain.Trollo_users;
import com.packt.domain.repository.impl.UserRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
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
            public String checkUser (@ModelAttribute("user") @Valid Trollo_users user, BindingResult result, HttpServletRequest request)
             {
                 userRepository = new UserRepositoryImpl();
                 boolean isValid;
                 System.out.println(user.getName()+" "+ user.getPassword());

                 Trollo_users uzytkownik=  userRepository.read(user.getName());
                 System.out.println(uzytkownik.getName()+" "+uzytkownik.getPassword());
              if(uzytkownik==null||(uzytkownik.getPassword().equals(user.getPassword())!=true))
              {
                  isValid=false;
                  return "redirect:/login";
              }
                 else {

                  return "redirect:/index";
              }


             }


}
