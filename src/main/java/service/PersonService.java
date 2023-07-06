package service;

import base.service.BaseService;
import entity.Person;

public interface PersonService extends BaseService<Person,Long> {
    Person findByUsernameAndPassword(String username, String password);

}
