package com.pluralsite.fundamentalsSB.service;

import com.pluralsite.fundamentalsSB.data.Person;
import com.pluralsite.fundamentalsSB.exception.PersonNotFoundException;
import com.pluralsite.fundamentalsSB.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Iterable<Person> listPersons() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> listOfPersons() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person findPerson(long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()){
            return optionalPerson.get();
        }
        else{
            throw new PersonNotFoundException("Person Not Found");
        }

    }
}
