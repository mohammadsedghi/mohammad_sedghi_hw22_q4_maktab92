package repository;

import base.repository.BaseRepository;
import entity.Person;

import java.util.Optional;

public interface PersonRepository extends BaseRepository<Person,Long> {
    Optional<Person> findByUsernameAndPassword(String username, String password);
}
