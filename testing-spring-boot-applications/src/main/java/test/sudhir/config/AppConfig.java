package test.sudhir.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.sudhir.domain.UserRepository;

/**
 * @author sudhir
 *         Date:18/12/16
 *         Time:10:06 AM
 *         Project:testing-spring-boot-applications
 */
@Configuration
public class AppConfig {
    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository){
       return (args)->{
           /*Stream.of("Sudhir").forEach(name->userRepository.save(new User(name,new
                   VehicleIdentificationNumber("12345"))));*/
       };
    }
}
