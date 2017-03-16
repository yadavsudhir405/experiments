package test.sudhir;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import test.sudhir.domain.User;
import test.sudhir.domain.UserRepository;
import test.sudhir.domain.VehicleIdentificationNumber;
import test.sudhir.service.VehicleDetails;
import test.sudhir.service.VehicleDetailsService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class ApplicationIntegrationTestIT {
	private  static final VehicleIdentificationNumber VEHICLE_IDENTIFICATION_NUMBER=new VehicleIdentificationNumber
			("12345");

	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	private VehicleDetailsService vehicleDetailsService;

	@Autowired
	private UserRepository userRepository;

	@Before
	public void setup(){
		BDDMockito.given(vehicleDetailsService.getVehicleDetails(VEHICLE_IDENTIFICATION_NUMBER)).
				willReturn(new VehicleDetails("Honda","Civic"));
		User user=new User("Sudhir",VEHICLE_IDENTIFICATION_NUMBER);
		userRepository.save(user);
	}

	@Test
	public void getVehicleDetails() {
		ResponseEntity<String> response=restTemplate.getForEntity("/{username}/vehicle",
				String.class,"Sudhir");
		Assertions.assertThat(response.getBody()).contains("Honda");
	}

}
