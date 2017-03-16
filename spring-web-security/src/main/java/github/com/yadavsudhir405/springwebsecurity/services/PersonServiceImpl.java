package github.com.yadavsudhir405.springwebsecurity.services;

import github.com.yadavsudhir405.springwebsecurity.domain.Person;
import github.com.yadavsudhir405.springwebsecurity.domain.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author sudhir
 *         Date:15/3/17
 *         Time:11:44 AM
 *         Project:spring-web-security
 */
@Component
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person person) {
        Assert.notNull(person,"Person can not be null");
        Assert.notNull(person.getName(),"Person's name can not be null or empty");
        return this.personRepository.save(person);
    }

    @Override
    public Person getPersonById(Long id) {
        return null;
    }

    @Override
    public List<Person> getPersonByName(String name) {
        return null;
    }
}
