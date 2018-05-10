package com.hendisantika.thymeleafangularjs.controller;

import com.hendisantika.thymeleafangularjs.domain.City;
import com.hendisantika.thymeleafangularjs.service.ApiService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : thymeleaf-angularjs
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/05/18
 * Time: 05.50
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/ajax/report")
public class AjaxController {
    @Autowired
    private ApiService apiService;

    @Secured({"ROLE_demo"})
    @PostMapping
    public List<City> generateReport(@RequestBody List<City> cities) throws JRException {
        apiService.generateReport(cities);
        return cities;
    }

}
