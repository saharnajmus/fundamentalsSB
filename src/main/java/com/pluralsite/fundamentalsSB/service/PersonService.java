package com.pluralsite.fundamentalsSB.service;

import com.pluralsite.fundamentalsSB.data.Person;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PersonService {
    Iterable<Person> listPersons();
    List<Person> listOfPersons();
    Person findPerson(long id);
}
