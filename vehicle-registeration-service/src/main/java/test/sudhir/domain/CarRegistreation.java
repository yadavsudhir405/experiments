package test.sudhir.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author sudhir
 *         Date:18/12/16
 *         Time:11:53 AM
 *         Project:vehicleregisterationservice
 */
@Entity
public class CarRegistreation {

    @Id
    private Long registerationNumber;

    @OneToOne
    private Car car;

    public CarRegistreation() {
    }

    public CarRegistreation(Long registerationNumber, Car car) {
        this.registerationNumber = registerationNumber;
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarRegistreation that = (CarRegistreation) o;

        if (registerationNumber != null ? !registerationNumber.equals(that.registerationNumber) : that.registerationNumber != null)
            return false;
        return car != null ? car.equals(that.car) : that.car == null;

    }

    @Override
    public int hashCode() {
        int result = registerationNumber != null ? registerationNumber.hashCode() : 0;
        result = 31 * result + (car != null ? car.hashCode() : 0);
        return result;
    }

    public Long getRegisterationNumber() {
        return registerationNumber;
    }

    public Car getCar() {
        return car;
    }
}
