package com.packt.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wp on 01.05.2016.
 */
@Controller
public class indexController {

    @RequestMapping(value = "index")
           public String index()
    {
        return "index";
    }
}
