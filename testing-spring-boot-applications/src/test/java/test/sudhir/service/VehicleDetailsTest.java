package test.sudhir.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author sudhir
 *         Date:19/12/16
 *         Time:6:55 PM
 *         Project:testing-spring-boot-applications
 */
@RunWith(SpringRunner.class)
@JsonTest
public class VehicleDetailsTest {

    @Autowired
    private JacksonTester<VehicleDetails> jacksonTester;

    @Test
    public void serializeJson() throws IOException{
        VehicleDetails vehicleDetails=new VehicleDetails("Honda","Civic");
        Assertions.assertThat(this.jacksonTester.write(vehicleDetails)).isEqualTo("vehicleDetails.json");
        Assertions.assertThat(this.jacksonTester.write(vehicleDetails)).isEqualToJson("vehicleDetails.json");
        Assertions.assertThat(this.jacksonTester.write(vehicleDetails)).hasJsonPathStringValue("@.make");
        Assertions.assertThat(this.jacksonTester.write(vehicleDetails)).extractingJsonPathStringValue("@.make")
                .isEqualTo("Honda");
    }
    @Test
    public void deserialize() throws  Exception{
        String content="{\"make\":\"Honda\",\"model\":\"Civic\"}";
        Assertions.assertThat(this.jacksonTester.parse(content)).isEqualTo(new VehicleDetails("Honda","Civic"));
        Assertions.assertThat(this.jacksonTester.parse(content).getObject().getMake()).isEqualTo("Honda");
    }
}
