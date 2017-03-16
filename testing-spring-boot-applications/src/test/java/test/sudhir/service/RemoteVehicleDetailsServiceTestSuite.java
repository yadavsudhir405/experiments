package test.sudhir.service;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.HttpServerErrorException;
import test.sudhir.domain.VehicleIdentificationNumber;

/**
 * @author sudhir
 *         Date:19/12/16
 *         Time:5:24 PM
 *         Project:testing-spring-boot-applications
 */
@RunWith(SpringRunner.class)
@RestClientTest({RemoteVehicleDetailsService.class,RemoteVehicleDetailsServiceProperties.class})
@TestPropertySource(properties = "vehicle.service.root-url=http://example.com/")
public class RemoteVehicleDetailsServiceTestSuite {

    private static final String VIN="12345";

    @Rule
    public ExpectedException expectedException=ExpectedException.none();

    @Autowired
    private RemoteVehicleDetailsService remoteVehicleDetailsService;

    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    @Test
    public void getVehicleDetailsWhenVINisNullShouldThrowException() throws Exception{
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("VIN must not be null");
        remoteVehicleDetailsService.getVehicleDetails(null);
    }

    @Test
    public void getVehicleDetailsWhenResultIsSuccessShouldReturnDetail() throws  Exception{
        this.mockRestServiceServer.expect(MockRestRequestMatchers.requestTo("http://example" +
                ".com/vehicle/"+VIN+"/details")).andRespond(
                MockRestResponseCreators.withSuccess(getClassPathResource("vehicleDetails.json"), MediaType.APPLICATION_JSON)
        );
        VehicleDetails vehicleDetails=this.remoteVehicleDetailsService.getVehicleDetails(new
                VehicleIdentificationNumber("12345"));
        Assertions.assertThat(vehicleDetails.getMake()).isEqualTo("Honda");
        Assertions.assertThat(vehicleDetails.getModel()).isEqualTo("Civic");
    }

    @Test
    public void getVehicleDetailsWhenResultIsNotFoundShouldThrowException() throws Exception{

        this.mockRestServiceServer.expect(MockRestRequestMatchers.requestTo("http://example" +
                ".com/vehicle/"+VIN+"/details")).andRespond(
                MockRestResponseCreators.withStatus(HttpStatus.NOT_FOUND)
        );
        expectedException.expect(VehicleIdentificationNumberNotFoundException.class);
        this.remoteVehicleDetailsService.getVehicleDetails(new VehicleIdentificationNumber(VIN));
    }

    @Test
    public void getVehicleDetailsWhenServerErrorShouldThrowException() throws Exception{

        this.mockRestServiceServer.expect(MockRestRequestMatchers.requestTo("http://example" +
                ".com/vehicle/"+VIN+"/details")).andRespond(
                MockRestResponseCreators.withServerError()
        );
        expectedException.expect(HttpServerErrorException.class);
        this.remoteVehicleDetailsService.getVehicleDetails(new VehicleIdentificationNumber(VIN));
    }
    private ClassPathResource getClassPathResource(String path) {
        return new ClassPathResource(path, getClass());
    }
}
