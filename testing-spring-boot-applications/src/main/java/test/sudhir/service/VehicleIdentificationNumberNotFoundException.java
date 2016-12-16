package test.sudhir.service;

import test.sudhir.domain.VehicleIdentificationNumber;

/**
 * @author sudhir
 *         Date:11/12/16
 *         Time:4:14 PM
 *         Project:testing-spring-boot-applications
 */
public class VehicleIdentificationNumberNotFoundException extends RuntimeException {

    private VehicleIdentificationNumber vehicleIdentificationNumber;

    public VehicleIdentificationNumberNotFoundException(VehicleIdentificationNumber vehicleIdentificationNumber){
        this(vehicleIdentificationNumber,null);
    }

    public VehicleIdentificationNumberNotFoundException(VehicleIdentificationNumber vehicleIdentificationNumber,Throwable throwable){

        super("Unable to find VehicleIndentifactionNumber "+vehicleIdentificationNumber,throwable);
        this.vehicleIdentificationNumber=vehicleIdentificationNumber;
    }

    public VehicleIdentificationNumber getVehicleIdentificationNumber() {
        return this.vehicleIdentificationNumber;
    }
}
