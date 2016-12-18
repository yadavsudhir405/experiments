package test.sudhir.web;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.BDDMockito;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import test.sudhir.domain.User;
import test.sudhir.domain.UserRepository;
import test.sudhir.domain.VehicleIdentificationNumber;
import test.sudhir.service.VehicleDetails;
import test.sudhir.service.VehicleDetailsService;

/**
 * @author sudhir
 *         Date:18/12/16
 *         Time:5:07 PM
 *         Project:testing-spring-boot-applications
 */
public class UserVehicleServiceTest {

    private static final VehicleIdentificationNumber VIN=new VehicleIdentificationNumber("12345");

    @Rule
    public ExpectedException expectedException=ExpectedException.none();

    @Mock
    private VehicleDetailsService vehicleDetailsService;

    @Mock
    private UserRepository userRepository;

    private UserVehicleService userVehicleService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        this.userVehicleService=new UserVehicleService(userRepository,vehicleDetailsService);
    }

    @Test
    public void getVehicleDetailsWhenUsernameisNullShouldThrowException() throws Exception{

        this.expectedException.expect(IllegalArgumentException.class);
        this.expectedException.expectMessage("Username must not be null");
        userVehicleService.getVehicleDetails(null);
    }

    @Test
    public void getVehicleDetailsWhenUsernameNotFoundShouldThrowException() throws Exception{
        BDDMockito.given(this.userRepository.findByUsername(Matchers.anyString())).willReturn(null);
        this.expectedException.expect(UserNameNotFoundException.class);
        this.userVehicleService.getVehicleDetails("whatspp");
    }

    @Test
    public void getVehicleDetailsShouldReturnVechicaleDetailModel(){
        BDDMockito.given(this.userRepository.findByUsername("Sudhir")).willReturn(new User("Sudhir",VIN));
        VehicleDetails vehicleDetails=new VehicleDetails("Honda","Civic");
        BDDMockito.given(this.vehicleDetailsService.getVehicleDetails(VIN)).willReturn(vehicleDetails);
        VehicleDetails actualVehicleDetail=this.userVehicleService.getVehicleDetails("Sudhir");
        Assertions.assertThat(actualVehicleDetail).isEqualTo(vehicleDetails);

    }
}
