package org.example.qrcode.controllers;

import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import org.example.qrcode.models.Person;
import org.example.qrcode.services.PersonService;
import org.example.qrcode.utils.QRCodeGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/people")
public class PersonController {

    private final PersonService personService;

    @Value("${qrcode.output.directory}")
    String qrCodePath;

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

    @GetMapping(path = "/QRCodes/{id}")
    public void generateQRCodes(@PathVariable Long id) throws IOException, WriterException {
        Person person = personService.getPerson(id);
         QRCodeGenerator.generateQRCode(person, qrCodePath);
    }
}
