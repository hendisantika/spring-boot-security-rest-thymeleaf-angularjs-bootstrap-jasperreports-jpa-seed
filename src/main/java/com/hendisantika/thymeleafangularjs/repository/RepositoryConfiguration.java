package com.hendisantika.thymeleafangularjs.repository;

import com.hendisantika.thymeleafangularjs.domain.City;
import com.hendisantika.thymeleafangularjs.domain.Country;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * Created by IntelliJ IDEA.
 * Project : thymeleaf-angularjs
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/05/18
 * Time: 06.33
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class RepositoryConfiguration extends RepositoryRestMvcConfiguration {
    @Override
    public RepositoryRestConfiguration config() {
        RepositoryRestConfiguration config = super.config();
        config.setBasePath("/rest");
        config.exposeIdsFor(City.class, Country.class);
        return config;
    }
}