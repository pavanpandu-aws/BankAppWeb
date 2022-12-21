package com.kluevja.bankappweb.controllers;

import com.kluevja.bankappweb.models.Client;
import com.kluevja.bankappweb.services.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/client")
@Slf4j
public class ClientController {

    @Autowired
    private ClientService clientService;


    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Client client, RedirectAttributes model) {
        log.info("Попытка создать клиента " + client);
        if (clientService.createClient(client)) {
            model.addFlashAttribute("msg", "Пользователь успешно создан");
        } else {
            model.addFlashAttribute("msg", "Не удалось создать пользователя");
        }
        return new ModelAndView("redirect:/client");
    }

    @GetMapping("/get")
    public ModelAndView get(@RequestParam Long id, RedirectAttributes model) {
        Optional<Client> client = clientService.getClient(id);
        if (client.isPresent()) {
            model.addFlashAttribute("client", client.get());
        } else {
            model.addFlashAttribute("msg", "Не удалось найти пользователя");
        }
        return new ModelAndView("redirect:/client");
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute Client client, RedirectAttributes model) {
        try {
            clientService.updateClient(client);
            model.addFlashAttribute("msg", "Пользователь успешно обновлен");
        } catch (Exception e) {
            model.addFlashAttribute("msg", "Не удалось найти пользователя");
            log.error("Пользователя с таким ID не найдено : " + client.getId());
        }
        return new ModelAndView("redirect:/client");
    }

    @PostMapping("/delete")
    public ModelAndView delete(@RequestParam Long id, RedirectAttributes model) {
        if (clientService.deleteClient(id)) {
            model.addFlashAttribute("msg", "Пользователь успешно удален");
        } else {
            model.addFlashAttribute("msg", "Не удалось удалить пользователя");
        }
        return new ModelAndView("redirect:/client");
    }
}
