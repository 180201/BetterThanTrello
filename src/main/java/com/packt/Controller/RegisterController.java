package com.packt.Controller;

import com.packt.domain.Uzytkownik;
import com.packt.domain.repository.impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by WP on 16.04.2016.
 */

@Controller
@RequestMapping(value = "/register", method = RequestMethod.GET)

public class RegisterController {

    @Autowired
    UserRepositoryImpl userRepository;

    public String Register() {
        return "Register";
    }

    public void processAddNewUser() throws ParseException {

        userRepository=new UserRepositoryImpl();

        // utworzenie nowego uzytkownika i wrzucenie go do bazy
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = "2011-12-31 00:00:00";
        java.util.Date date = sdf.parse(strDate);
        java.sql.Date sqlDate = new Date(date.getTime());
        Uzytkownik uzytkownik1 =new Uzytkownik(sqlDate,sqlDate,2,3,"aahggha","gbubugg","ffhhhhf");

        userRepository.create(uzytkownik1);
    }
}
