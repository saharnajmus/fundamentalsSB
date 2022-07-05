package com.pluralsite.fundamentalsSB.repository;

import com.pluralsite.fundamentalsSB.data.Passport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends CrudRepository<Passport,Long> {
}
