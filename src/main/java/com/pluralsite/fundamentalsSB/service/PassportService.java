package com.pluralsite.fundamentalsSB.service;

import com.pluralsite.fundamentalsSB.data.Passport;
import com.pluralsite.fundamentalsSB.data.Person;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PassportService {
    Iterable<Passport> listPassports();
    List<Passport> listOfPassports();
}
