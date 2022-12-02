package com.kluevja.bankappweb.controllers;

import com.kluevja.bankappweb.models.Account;
import com.kluevja.bankappweb.models.Client;
import com.kluevja.bankappweb.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    public AccountService accountService;

    @PostMapping("/create")
    public ModelAndView create (@RequestParam Long id, RedirectAttributes model) {

        if (accountService.createAccount(id)) {
            model.addFlashAttribute("msg", "Счет успешно создан");
        } else {
            model.addFlashAttribute("msg", "Не удалось создать счет");
        }

        return new ModelAndView("redirect:/account");
    }

    @GetMapping("/get")
    public ModelAndView get (@RequestParam Long id, RedirectAttributes model) {

        return new ModelAndView("redirect:/account");
    }

    @PostMapping("/update")
    public ModelAndView update (@ModelAttribute Account account, RedirectAttributes model) {

        return new ModelAndView("redirect:/account");
    }

    @PostMapping("/delete")
    public ModelAndView delete (@RequestParam Long id, RedirectAttributes model) {

        return new ModelAndView("redirect:/account");
    }
}
