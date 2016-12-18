package test.sudhir.domain;

import javax.persistence.*;

/**
 * @author sudhir
 *         Date:18/12/16
 *         Time:11:51 AM
 *         Project:vehicleregisterationservice
 */
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private String make;

    public Car(String model, String make) {
        this.model = model;
        this.make = make;
    }

    public Car() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != null ? !id.equals(car.id) : car.id != null) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        return make != null ? make.equals(car.make) : car.make == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (make != null ? make.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }
}
