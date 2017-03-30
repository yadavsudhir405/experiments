package github.com.yadavsudhir405.springwebsecurity.controller;

import github.com.yadavsudhir405.springwebsecurity.domain.Person;
import github.com.yadavsudhir405.springwebsecurity.domain.PersonRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sudhir
 *         Date:15/3/17
 *         Time:11:35 AM
 *         Project:spring-web-security
 */
@RestController
@RequestMapping(path = "/api")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping(path = "addperson")
    public Person addPerson(@RequestBody Person person){
        System.out.println("Inside Controller "+person);
        return personRepository.save(person);
    }
}
