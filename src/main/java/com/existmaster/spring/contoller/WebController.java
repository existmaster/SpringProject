package com.existmaster.spring.contoller;

import com.existmaster.spring.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by existmaster on 2015. 8. 12..
 */
@Controller
public class WebController {

    @Autowired
    GameService gameService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView hello(){
        return new ModelAndView("hello").addObject("name", "Sung-Yoel");
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

}
