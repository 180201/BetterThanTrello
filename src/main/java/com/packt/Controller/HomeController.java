package com.packt.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by WP on 16.04.2016.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String welcome() {

        return "home";
    }
}