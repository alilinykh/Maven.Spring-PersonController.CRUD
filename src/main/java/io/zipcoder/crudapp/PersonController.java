package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @PostMapping ("/people")
    public Person createPerson(@RequestBody Person p) {
        return this.personRepository.save(p);
    }
    @GetMapping("/people/{id}")
    public Person getPerson(@PathVariable int id) {
        return this.personRepository.findOne(id);
    }
    @GetMapping("/people")
    public List<Person> getPersonList() {
        return (List<Person>)this.personRepository.findAll();
    }
    @PutMapping("/people/{id}")
    public Person updatePerson(@PathVariable int id, @RequestBody Person request) {
        Person old = getPerson(id);
        old.setFirstName(request.getFirstName());
        old.setLastName(request.getLastName());

        return this.personRepository.save(old);
    }
    @DeleteMapping("/people/{id}")
    public void deletePerson(@PathVariable int id) {
        this.personRepository.delete(id);
    }

}
