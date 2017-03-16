package github.com.yadavsudhir405.springwebsecurity.services;

import github.com.yadavsudhir405.springwebsecurity.domain.Person;

import java.util.List;

/**
 * @author sudhir
 *         Date:15/3/17
 *         Time:11:40 AM
 *         Project:spring-web-security
 */
public interface PersonService {
    Person save(Person person);
    Person getPersonById(Long id);
    List<Person> getPersonByName(String name);
}
