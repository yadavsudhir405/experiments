package test.sudhir.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sudhir
 *         Date:11/12/16
 *         Time:4:04 PM
 *         Project:testing-spring-boot-applications
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

}
