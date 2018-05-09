package com.hendisantika.thymeleafangularjs.service;

import com.hendisantika.thymeleafangularjs.domain.City;
import com.hendisantika.thymeleafangularjs.domain.Country;
import com.hendisantika.thymeleafangularjs.report.CustomJRDataSource;
import com.hendisantika.thymeleafangularjs.repository.CityRepository;
import com.hendisantika.thymeleafangularjs.repository.CountryRepository;
import net.sf.jasperreports.engine.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : thymeleaf-angularjs
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/05/18
 * Time: 06.06
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ApiService {
    private static final Logger logger = LogManager.getLogger(ApiService.class);

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CountryRepository countryRepository;

    public void addCity(String cityName, String countryName, Long population) {
        City city = new City().setName(cityName).setPopulation(population);
        Country country = countryRepository.findByName(countryName);
        city.setCountry(country);
        country.addCity(city);
        cityRepository.save(city);

    }

    public void addCountry(String countryName) {
        Country country = new Country().setName(countryName);
        country = countryRepository.save(country);
    }

    public void generateReport(List<City> cities) throws JRException {
        JasperReport jasperReport;
        JasperPrint jasperPrint;
        jasperReport = JasperCompileManager
                .compileReport("src/main/resources/static/jasper/report.jrxml");
        CustomJRDataSource<City> dataSource = new CustomJRDataSource<City>()
                .initBy(cities);
        jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(),
                dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint,
                "src/main/resources/static/jasper/report.pdf");
    }

    @PostConstruct
    public void init() {
        logger.info("ApiService.init()");
        addCountry("USA");
        addCountry("RUSSIA");
        addCity("Los Angeles", "USA", 10000L);
        addCity("New York", "USA", 20000L);
        addCity("Washington", "USA", 30000L);
        addCity("Moscow", "RUSSIA", 90000L);
        addCity("Novosibirsk", "RUSSIA", 10000L);
        addCity("Jakarta", "INDONESIA", 10000L);
        addCity("Bandung", "INDONESIA", 10000L);
    }
}


