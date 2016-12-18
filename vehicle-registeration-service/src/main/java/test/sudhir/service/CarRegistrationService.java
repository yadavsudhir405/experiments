package test.sudhir.service;

import org.springframework.stereotype.Component;
import test.sudhir.domain.Car;
import test.sudhir.domain.CarRegisterationRepository;
import test.sudhir.domain.CarRegistreation;

/**
 * @author sudhir
 *         Date:18/12/16
 *         Time:12:01 PM
 *         Project:vehicleregisterationservice
 */
@Component
public class CarRegistrationService {

    private CarRegisterationRepository carRegisterationRepository;

    public CarRegistrationService(CarRegisterationRepository carRegisterationRepository) {
        this.carRegisterationRepository = carRegisterationRepository;
    }

    public Car getCarByRegisterationId(Long id) throws CarRegisterationNotFoundException{
        CarRegistreation carRegistreation= carRegisterationRepository.findOne(id);
        if(carRegistreation==null){
            throw new CarRegisterationNotFoundException(id);
        }
        return carRegistreation.getCar();
    }
}
