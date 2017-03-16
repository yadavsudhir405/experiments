package github.com.yadavsudhir405.experiments.springBootSwaaggerUi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SpringBootSwaggerUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwaggerUiApplication.class, args);
	}
}
