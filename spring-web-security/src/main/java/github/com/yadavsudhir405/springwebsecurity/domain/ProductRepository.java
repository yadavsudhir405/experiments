package github.com.yadavsudhir405.springwebsecurity.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author sudhir
 *         Date:3/5/17
 *         Time:4:44 PM
 *         Project:spring-web-security
 */
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,Long> {
}
