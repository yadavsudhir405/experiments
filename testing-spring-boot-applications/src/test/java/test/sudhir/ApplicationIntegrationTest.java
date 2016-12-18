package test.sudhir;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest(randomPort = true)
@SpringApplicationConfiguration(TestingSpringBootApplication.class)
public class ApplicationIntegrationTest {

	@Value("${local.server.port}")
	private int port;

	private TestRestTemplate restTemplate=new TestRestTemplate();

	@Test
	public void testProprtryFile() {

		ResponseEntity<String> response=restTemplate.getForEntity("http://localhost:{port}/{username}/vehicle",
				String.class,this.port,"Sudhir");
		Assertions.assertThat(response.getBody()).contains("Honda");
	}

}
