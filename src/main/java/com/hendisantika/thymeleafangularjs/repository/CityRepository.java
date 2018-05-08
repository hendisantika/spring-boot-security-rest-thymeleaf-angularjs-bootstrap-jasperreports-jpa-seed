package com.hendisantika.thymeleafangularjs.repository;

import com.hendisantika.thymeleafangularjs.domain.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by IntelliJ IDEA.
 * Project : thymeleaf-angularjs
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/05/18
 * Time: 06.32
 * To change this template use File | Settings | File Templates.
 */
@RepositoryRestResource(collectionResourceRel = "all", path = "city")
public interface CityRepository extends CrudRepository<City, String> {
}
