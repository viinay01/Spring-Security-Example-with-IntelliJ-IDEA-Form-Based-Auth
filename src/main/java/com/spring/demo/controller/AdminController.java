package com.spring.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Vinay Kumar
 **/
@Controller
public class AdminController {

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String welcome() {
        return "index";
    }

    @RequestMapping(value="/home", method=RequestMethod.GET)
    public String home() {
        return "home";
    }

//    @RequestMapping(value="/admin", method=RequestMethod.GET)
//    public String admin() {
//        return "admin";
//    }

//    @RequestMapping(value="/login", method=RequestMethod.GET)
//    public String login() {
//        return "login";
//    }

//    @RequestMapping(value="/logout", method=RequestMethod.POST)
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/";
//    }
}
