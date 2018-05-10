package com.hendisantika.thymeleafangularjs.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : thymeleaf-angularjs
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/05/18
 * Time: 05.49
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class WebController {

    @Secured({"ROLE_demo"})
    @RequestMapping("/")
    public String home(Map<String, Object> model) {

        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "login";
    }

    @RequestMapping("/ng-templates/{resource}")
    public String angularHtmlTemplate(@PathVariable("resource") String resource) {

        return "ng-templates/" + resource;
    }

}