package com.pluralsite.fundamentalsSB.service;

import com.pluralsite.fundamentalsSB.data.Passport;
import com.pluralsite.fundamentalsSB.repository.PassportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassportServiceImpl implements PassportService{
    private final PassportRepository passportRepository;

    public PassportServiceImpl(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Override
    public Iterable<Passport> listPassports() {
        return passportRepository.findAll();
    }

    @Override
    public List<Passport> listOfPassports() {
        return (List<Passport>) passportRepository.findAll();
    }
}
