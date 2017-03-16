package test.sudhir.domain;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author sudhir
 *         Date:19/12/16
 *         Time:5:10 PM
 *         Project:testing-spring-boot-applications
 */
public class VehicleIdentificationNumberTestSuite {

    private static final String VIN="12345";

    @Rule
    public ExpectedException expectedException=ExpectedException.none();

    @Test
    public void vehicleIdentificationNumberWhennumberisnullShouldthrowException() throws Exception{
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("VIN must not be null");
        new VehicleIdentificationNumber(null);
    }
    @Test
    public void vehicleIdentificationNumberWhennumberLengthIsGreaterThanFiveShouldThrowException() throws Exception{
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("VIN must be exactly 5 characters");
        new VehicleIdentificationNumber("12345666");
    }

    @Test
    public void vehicleIdentificationNumberWhennumberLengthIsLesserThanFiveShouldThrowException() throws Exception{
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("VIN must be exactly 5 characters");
        new VehicleIdentificationNumber("1234");
    }
    @Test
    public void equlasAndHashMethodShouldPass(){
        VehicleIdentificationNumber vehicleIdentificationNumber=new VehicleIdentificationNumber("12345");
        VehicleIdentificationNumber vehicleIdentificationNumber1=vehicleIdentificationNumber;
        VehicleIdentificationNumber vehicleIdentificationNumber2=new VehicleIdentificationNumber("12345");
        Assertions.assertThat(vehicleIdentificationNumber).isEqualTo(vehicleIdentificationNumber1);
        Assertions.assertThat(vehicleIdentificationNumber1).isEqualTo(vehicleIdentificationNumber2);
        Assertions.assertThat(vehicleIdentificationNumber).isEqualTo(vehicleIdentificationNumber2);

        Assertions.assertThat(vehicleIdentificationNumber.hashCode()).isEqualTo(vehicleIdentificationNumber1.hashCode
                ());
        Assertions.assertThat(vehicleIdentificationNumber1.hashCode()).isEqualTo
                (vehicleIdentificationNumber2.hashCode());
    }
}
