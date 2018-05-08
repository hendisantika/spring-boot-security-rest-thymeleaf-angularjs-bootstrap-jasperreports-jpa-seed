package com.hendisantika.thymeleafangularjs.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * Project : thymeleaf-angularjs
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 08/05/18
 * Time: 07.09
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class City implements Serializable {

    private static final long serialVersionUID = 3977347517121289291L;

    @Id
    private String name;

    @Column(nullable = false)
    private Long population;

    @ManyToOne
    private Country country;

    public String getName() {
        return name;
    }

    public City setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPopulation() {
        return population;
    }

    public City setPopulation(Long population) {
        this.population = population;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public City setCountry(Country country) {
        this.country = country;
        return this;
    }
}
