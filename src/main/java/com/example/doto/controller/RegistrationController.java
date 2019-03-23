package com.example.doto.controller;

import com.example.doto.domain.User;
import com.example.doto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Map<String, Object> model) {

            if(!userService.createUser(user)) {
                model.put("message", "Пользователь с таким именем существует");
                return "registration";
            }



        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = userService.activateUser(code);

        if(isActivated){
            model.addAttribute("message", "Пользователен активирован");
        } else {
            model.addAttribute("message", "Ошибка");
        }

        return "login";
    }
}
