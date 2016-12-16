package test.sudhir;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import test.sudhir.config.MailServerConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestingSpringBootApplicationTests {

	@Autowired
	private MailServerConfiguration mailServerConfiguration;

	@Test
	public void testProprtryFile() {
		//assertThat(mailServerConfiguration.getHost().equals("localhost"));
		//assert(mailServerConfiguration.getHost().equals("localhost1"));
		assertThat(mailServerConfiguration.getHost().equals("localhost1")).isTrue();

	}

}
