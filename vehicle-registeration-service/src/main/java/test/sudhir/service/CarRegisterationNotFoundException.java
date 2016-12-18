package test.sudhir.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author sudhir
 *         Date:18/12/16
 *         Time:12:20 PM
 *         Project:vehicleregisterationservice
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarRegisterationNotFoundException extends Exception {

    private Long registersationNumer;

    public CarRegisterationNotFoundException(Long registersationNumer,Throwable cause) {
        super("Car with registreation Number "+registersationNumer+" not found", cause);
        this.registersationNumer = registersationNumer;
    }
    public CarRegisterationNotFoundException(Long registersationNumer){
        super("Car with registreation Number "+registersationNumer +" not found");
        this.registersationNumer=registersationNumer;
    }
}
