package com.existmaster.spring.contoller;

import com.existmaster.spring.model.Game;
import com.existmaster.spring.model.NameType;
import com.existmaster.spring.repository.NameTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by existmaster on 2015. 8. 25..
 */
@Controller
public class NameController {

    @Autowired
    NameTypeRepository nameTypeRepository;

    @RequestMapping("game/nameTypeForm")
    public String home() {
        return "game/nameTypeForm";
    }

    @ResponseBody
    @RequestMapping(value = "game/nameType", method = RequestMethod.POST)
    public NameType newNameType(NameType nameType, Model model) {
        NameType nameType1 = nameTypeRepository.save(nameType);

        return nameType1;

    }
}
