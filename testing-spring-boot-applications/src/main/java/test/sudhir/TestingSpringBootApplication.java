package test.sudhir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import test.sudhir.config.MailServerConfiguration;

@SpringBootApplication
public class TestingSpringBootApplication {


	private static MailServerConfiguration.Smtp smtp;

	public static void main(String[] args) {
		ApplicationContext applicationContext=SpringApplication.run(TestingSpringBootApplication.class, args);
		MailServerConfiguration mailServerConfiguration=applicationContext.getBean("mailServerConfiguration",
				MailServerConfiguration.class);
		System.out.println(mailServerConfiguration.getHost());
		smtp = mailServerConfiguration.getSmtp();
		System.out.println(mailServerConfiguration.getSmtp().isAuth());
	}
}
