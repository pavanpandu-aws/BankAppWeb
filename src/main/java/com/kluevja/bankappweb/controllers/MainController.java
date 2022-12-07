package com.kluevja.bankappweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/client")
    public String client() {
        return "client/index";
    }

    @GetMapping("/account")
    public String account() {
        return "account/index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
