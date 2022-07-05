package com.pluralsite.fundamentalsSB.data;

import javax.persistence.*;

@Entity
public class Passport {
    @Id
    @Column//(name = "passport_number")
    @GeneratedValue(strategy = GenerationType.AUTO)

    Long passportNumber;
    String countryName;
    @OneToOne
    @JoinColumn(name = "person_id")  //It simply means that our Passport entity will have a foreign key column named person_id referring to the primary attribute id of our Person  entity.
    Person person;

    public Passport() {
    }

    public Passport(Long passportNumber, String countryName) {
        this.passportNumber = passportNumber;
        this.countryName = countryName;
    }

    public Long getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(Long passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

     public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "passportNumber=" + passportNumber +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
