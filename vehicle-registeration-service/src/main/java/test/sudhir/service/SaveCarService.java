package test.sudhir.service;

import org.springframework.stereotype.Component;
import test.sudhir.domain.Car;
import test.sudhir.domain.CarRepository;

/**
 * @author sudhir
 *         Date:18/12/16
 *         Time:11:59 AM
 *         Project:vehicleregisterationservice
 */
@Component
public class SaveCarService {

    private final  CarRepository carRepository;

    public SaveCarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void save(Car car){
        carRepository.save(car);
    }

    public Car getCarById(Long id){
        return carRepository.findOne(id);
    }
}
