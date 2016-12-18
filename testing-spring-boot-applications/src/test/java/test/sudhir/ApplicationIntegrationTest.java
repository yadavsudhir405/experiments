package test.sudhir;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationIntegrationTest {

	@LocalServerPort
	private int port;

	private TestRestTemplate restTemplate=new TestRestTemplate();

	@Test
	public void testProprtryFile() {

		ResponseEntity<String> response=restTemplate.getForEntity("http://localhost:{port}/{username}/vehicle",
				String.class,this.port,"Sudhir");
		Assertions.assertThat(response.getBody()).contains("Honda");
	}

}
