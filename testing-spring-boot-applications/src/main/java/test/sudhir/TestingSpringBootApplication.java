package test.sudhir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class TestingSpringBootApplication {


	public static void main(String[] args) {
		ApplicationContext applicationContext=SpringApplication.run(TestingSpringBootApplication.class, args);
	}
}
