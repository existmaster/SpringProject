package com.existmaster.spring.contoller;

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

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView hello(){
        return new ModelAndView("hello").addObject("name", "Sung-Yoel");
    }


}
