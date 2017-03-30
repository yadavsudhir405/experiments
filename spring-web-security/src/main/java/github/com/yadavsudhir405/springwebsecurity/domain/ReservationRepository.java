package github.com.yadavsudhir405.springwebsecurity.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author sudhir
 *         Date:15/3/17
 *         Time:11:34 AM
 *         Project:spring-web-security
 */
@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
