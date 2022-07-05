package com.pluralsite.fundamentalsSB.repository;

import com.pluralsite.fundamentalsSB.data.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {
}
