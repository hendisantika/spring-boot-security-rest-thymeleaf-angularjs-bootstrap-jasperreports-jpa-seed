package com.hendisantika.thymeleafangularjs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : thymeleaf-angularjs
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 08/05/18
 * Time: 07.10
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class Country implements Serializable {
    private static final long serialVersionUID = 7215298992738155751L;

    @Id
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<City> cities = new ArrayList<City>();

    public String getName() {
        return name;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public List<City> getCities() {
        return cities;
    }

    public Country setCities(List<City> cities) {
        this.cities = cities;
        return this;
    }

    public Country addCity(City city) {
        if (!cities.contains(city)) {
            cities.add(city);
        }
        return this;
    }
}
