package ru.az.sample.web.controllers;

import ru.az.sample.model.User;
import ru.az.sample.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Welcome to Spring 4 MVC");
        return "welcome";
    }

    @ResponseBody
    @RequestMapping(value = "/listUsers", method = RequestMethod.GET)
    public List<User> listUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/listUsersHtml", method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "users";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public  String logout(){
    return "logout";
    }

}
