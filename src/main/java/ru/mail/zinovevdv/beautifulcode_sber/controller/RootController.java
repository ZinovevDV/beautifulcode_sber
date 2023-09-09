package ru.mail.zinovevdv.beautifulcode_sber.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller для редиректа с главной страницы (http://host:port/)
 * на страницу swagger'а, чтоб не запоминать ее адрес
 * работает только в профиле "dev", чтоб не утащить в релиз
 */
@Profile("dev")
@Controller
@RequestMapping("/")
public class RootController {
    @GetMapping
    public String swaggerUI(){
        return "redirect:swagger-ui/index.html";
    }
}
