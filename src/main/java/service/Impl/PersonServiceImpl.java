package service.Impl;


import base.repository.util.HibernateUtil;
import base.service.Impl.BaseServiceImpl;
import entity.Person;
import ir.maktab.mohammad_sedghi_hw22_q4_maktab92.HelloServlet;
import org.hibernate.Session;
import repository.Impl.PersonRepositoryImpl;
import repository.PersonRepository;
import service.PersonService;

import java.util.Optional;

public class PersonServiceImpl extends BaseServiceImpl<Person,Long, PersonRepository> implements PersonService {
    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository repository) {
        super(repository);
        this.personRepository=repository;
    }

    @Override
    public Person findByUsernameAndPassword(String username, String password) {
        Optional<Person> optionalPerson = personRepository.findByUsernameAndPassword(username, password);

        optionalPerson.ifPresentOrElse(
                person -> {
                    HelloServlet.member = person;
                },
                () -> {
                    System.out.println("Person not found. Start login again.");
                    HelloServlet.member=null;

                }
        );
        return null;
    }
}
