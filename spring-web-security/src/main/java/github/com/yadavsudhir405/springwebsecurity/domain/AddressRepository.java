package github.com.yadavsudhir405.springwebsecurity.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author sudhir
 *         Date:23/3/17
 *         Time:11:04 PM
 *         Project:spring-web-security
 */
@RepositoryRestResource()
public interface AddressRepository extends JpaRepository<Address,Long> {
}
