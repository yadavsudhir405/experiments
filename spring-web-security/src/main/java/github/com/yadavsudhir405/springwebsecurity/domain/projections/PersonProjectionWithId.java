package github.com.yadavsudhir405.springwebsecurity.domain.projections;

import github.com.yadavsudhir405.springwebsecurity.domain.Address;
import github.com.yadavsudhir405.springwebsecurity.domain.Person;
import org.springframework.data.rest.core.config.Projection;

/**
 * @author sudhir
 *         Date:24/3/17
 *         Time:12:22 PM
 *         Project:spring-web-security
 */
@Projection(name = "personwithid",types = Person.class)
public interface PersonProjectionWithId {
    Long getId();
    String getName();
    Address getAddress();
}
