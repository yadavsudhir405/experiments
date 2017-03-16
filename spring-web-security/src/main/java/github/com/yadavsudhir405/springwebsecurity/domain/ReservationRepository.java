package github.com.yadavsudhir405.springwebsecurity.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sudhir
 *         Date:15/3/17
 *         Time:11:34 AM
 *         Project:spring-web-security
 */
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
