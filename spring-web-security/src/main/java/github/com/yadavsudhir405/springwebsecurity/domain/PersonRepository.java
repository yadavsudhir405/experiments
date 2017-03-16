package github.com.yadavsudhir405.springwebsecurity.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sudhir
 *         Date:15/3/17
 *         Time:11:33 AM
 *         Project:spring-web-security
 */
@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}
