package com.pluralsite.fundamentalsSB.web;

import com.pluralsite.fundamentalsSB.data.Passport;
import com.pluralsite.fundamentalsSB.data.Person;
import com.pluralsite.fundamentalsSB.exception.PersonNotFoundException;
import com.pluralsite.fundamentalsSB.service.PassportService;
import com.pluralsite.fundamentalsSB.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
//@RestController = @Controller + @ResponseBody, ResponseBody annotation on controller indicates to spring that
@RequestMapping("/info")    // the return value of the method is serialized directly to the body of HTTP request.
public class PersonRestController {
    private PersonService personService;
    private PassportService passportService;

    public PersonRestController(PersonService personService, PassportService passportService) {
        this.personService = personService;
        this.passportService = passportService;
    }

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getAllPersons() { //ResponseEntity represents the entire HTTP response.it includes status code,
        List<Person> listOfPersons = personService.listOfPersons();
        return new ResponseEntity<List<Person>>(listOfPersons, HttpStatus.OK); //@RequestController doesn't work with our view technology thymeleaf, so method cannot return models.

    }

    @GetMapping("/passport")
    public ResponseEntity<List<Passport>> getAllPassports() { //ResponseEntity represents the entire HTTP response.it includes status code,
        List<Passport> listOfPassports = passportService.listOfPassports();   //headers and the response body
        return new ResponseEntity<List<Passport>>(listOfPassports, HttpStatus.OK); //@RequestController doesn't work with our view technology thymeleaf, so method cannot return models.
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable long id) {
        try {
            return new ResponseEntity<Person>(personService.findPerson(id), HttpStatus.OK);
        } catch (PersonNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found");
        }
    }
}
//REST:Representational State Transfer:It is a set of guidelines that application developer use to design APIs.
//REST is the most popular way to expose data from a server through an API.
//GraphQL is the query language for APIs.