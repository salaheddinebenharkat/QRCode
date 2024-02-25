package org.example.qrcode.controllers;

import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import org.example.qrcode.models.Person;
import org.example.qrcode.services.PersonService;
import org.example.qrcode.utils.QRCodeGenerator;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/people")
public class PersonController {

    private final PersonService personService;

    @PostMapping(path = "/add")
    public Person savePerson(@RequestBody Person person){
        return personService.addPerson(person);
    }

    @GetMapping(path = "/all")
    public List<Person> getPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "/{id}")
    public Person getPerson(@PathVariable Long id){
        return personService.getPerson(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
    }

    @GetMapping(path = "/QRCodes")
    public void generateQRCodes() throws IOException, WriterException {
        List<Person> people = personService.getAllPeople();
        if (!people.isEmpty()){
            for (Person person : people){
                QRCodeGenerator.generateQRCode(person);
                System.out.println(person.getFullName()+" OK !!!");
            }
        }
    }
}
