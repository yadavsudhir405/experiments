package test.sudhir.service;

import test.sudhir.domain.VehicleIdentificationNumber;

/**
 * @author sudhir
 *         Date:11/12/16
 *         Time:4:11 PM
 *         Project:testing-spring-boot-applications
 */
public interface VehicleDetailsService {

    VehicleDetails getVehicleDetails(VehicleIdentificationNumber vin)
            throws VehicleIdentificationNumberNotFoundException;
}
