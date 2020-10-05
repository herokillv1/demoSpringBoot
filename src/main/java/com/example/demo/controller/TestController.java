package com.example.demo.controller;

import com.example.demo.models.MyUser;
import com.example.demo.models.Role;
import com.example.demo.services.IMyUserService;
import com.example.demo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController {

    @Autowired
    private IMyUserService myUserService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/test")
    public ModelAndView get() {
        MyUser abc = myUserService.findById(2l);
        return new ModelAndView("/test", "abc", abc);
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("/create", "user", new MyUser());
    }

    @PostMapping("/create-user")
    public ModelAndView save(@ModelAttribute("user") MyUser user) {
        user.setRole(roleService.getRoleUser());
        myUserService.save(user);
        return new ModelAndView("/done");
    }
}
