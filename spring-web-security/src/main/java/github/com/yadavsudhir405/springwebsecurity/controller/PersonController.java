package github.com.yadavsudhir405.springwebsecurity.controller;

import github.com.yadavsudhir405.springwebsecurity.domain.Person;
import github.com.yadavsudhir405.springwebsecurity.domain.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sudhir
 *         Date:15/3/17
 *         Time:11:35 AM
 *         Project:spring-web-security
 */
@RestController
@RequestMapping(path = "/persons")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping()
    public Person addPerson(@RequestBody Person person){
        System.out.println("Inside Controller "+person);
        return personRepository.save(person);
    }
    @GetMapping
    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    @DeleteMapping
    public void delete(@RequestBody Person person){
        personRepository.delete(person);
    }
}
