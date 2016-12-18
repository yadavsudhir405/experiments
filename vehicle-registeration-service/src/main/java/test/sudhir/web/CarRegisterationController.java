package test.sudhir.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import test.sudhir.domain.Car;
import test.sudhir.model.CarVo;
import test.sudhir.service.CarRegisterationNotFoundException;
import test.sudhir.service.CarRegistrationService;

/**
 * @author sudhir
 *         Date:18/12/16
 *         Time:12:08 PM
 *         Project:vehicleregisterationservice
 */
@RestController()
public class CarRegisterationController {

    private final CarRegistrationService carRegistrationService;

    public CarRegisterationController(CarRegistrationService carRegistrationService) {
        this.carRegistrationService = carRegistrationService;
    }

    @GetMapping (path = "vehicle/{number}/details", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CarVo getCarDescription(@PathVariable String number) throws CarRegisterationNotFoundException{
        Car car= carRegistrationService.getCarByRegisterationId(Long.valueOf(number));
        CarVo carVo=new CarVo(car.getMake(),car.getModel());
        return carVo;
    }

}
