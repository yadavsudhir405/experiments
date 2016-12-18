package test.sudhir;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testProprtryFile() {

		ResponseEntity<String> response=restTemplate.getForEntity("/{username}/vehicle",
				String.class,"Sudhir");
		Assertions.assertThat(response.getBody()).contains("Honda");
	}

}
