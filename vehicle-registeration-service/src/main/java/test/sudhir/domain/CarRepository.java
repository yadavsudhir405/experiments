package test.sudhir.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sudhir
 *         Date:18/12/16
 *         Time:11:58 AM
 *         Project:vehicleregisterationservice
 */
@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
}
