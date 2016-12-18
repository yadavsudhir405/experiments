package test.sudhir.domain;

import org.springframework.util.Assert;

/**
 * @author sudhir
 *         Date:11/12/16
 *         Time:4:05 PM
 *         Project:testing-spring-boot-applications
 */
public class VehicleIdentificationNumber {

    private String vin;

    public VehicleIdentificationNumber(String vin) {
        Assert.notNull(vin, "VIN must not be null");
        Assert.isTrue(vin.length() == 5, "VIN must be exactly 5 characters");
        this.vin = vin;
    }

    @Override
    public int hashCode() {
        return this.vin.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return this.vin.equals(((VehicleIdentificationNumber) obj).vin);
    }

    @Override
    public String toString() {
        return this.vin;
    }
}
