package test.sudhir.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.sudhir.domain.CarRegisterationRepository;
import test.sudhir.domain.CarRepository;

/**
 * @author sudhir
 *         Date:18/12/16
 *         Time:12:30 PM
 *         Project:vehicleregisterationservice
 */
@Configuration
public class Appconfig {

    @Bean
    public CommandLineRunner commandLineRunner(CarRepository carRepository, CarRegisterationRepository carRegisterationRepository){
        return (strings)->{

           /* Car car=carRepository.save(new Car("Civic","Honda"));
            carRegisterationRepository.save(new CarRegistreation(12345L,car));*/


        };
    }
}
