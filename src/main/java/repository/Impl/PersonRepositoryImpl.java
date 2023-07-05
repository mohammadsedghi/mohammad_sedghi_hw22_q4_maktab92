package repository.Impl;


import base.repository.impl.BaseRepositoryImpl;
import entity.Person;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.PersonRepository;

import java.util.Optional;

public class PersonRepositoryImpl extends BaseRepositoryImpl<Person,Long>
        implements PersonRepository{
    private Session session;
    public PersonRepositoryImpl(Session session) {
        super(session);
        this.session=session;
    }

    @Override
    public Session getSession() {
        return session;
    }

    @Override
    public Class<Person> getEnityClass() {
        return Person.class;
    }

    @Override
    public Optional<Person> findByUsernameAndPassword(String username, String password) {
        try {
            String hql = "select p from Person p where p.username=:username AND p.password=:password";
            Query<Person> user = session.createQuery(hql, Person.class);
            user.setParameter("username", username);
            user.setParameter("password", password);
            return Optional.of(user.getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }
}
