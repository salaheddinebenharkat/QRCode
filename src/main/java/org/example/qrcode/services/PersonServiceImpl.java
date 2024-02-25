package org.example.qrcode.services;

import lombok.RequiredArgsConstructor;
import org.example.qrcode.models.Person;
import org.example.qrcode.repositories.PersonRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    private final PersonRepo personRepo;

    @Override
    public Person addPerson(Person person) {
        return personRepo.save(person);
    }

    @Override
    public Person getPerson(Long id) {
        return personRepo.findById(id).orElseThrow(() -> new RuntimeException("Person not found !!!"));
    }

    @Override
    public List<Person> getAllPeople() {
        return personRepo.findAll();
    }

    @Override
    public void deletePerson(Long id) {
        personRepo.deleteById(id);
    }
}
