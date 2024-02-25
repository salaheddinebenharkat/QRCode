package org.example.qrcode.services;

import org.example.qrcode.models.Person;

import java.util.List;

public interface PersonService {

    public Person addPerson(Person person);

    public Person getPerson(Long id);

    public List<Person> getAllPeople();

    public void deletePerson(Long id);
}
