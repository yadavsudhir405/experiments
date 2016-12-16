package test.sudhir.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import test.sudhir.domain.User;
import test.sudhir.domain.UserRepository;
import test.sudhir.service.VehicleDetails;
import test.sudhir.service.VehicleDetailsService;
import test.sudhir.service.VehicleIdentificationNumberNotFoundException;

/**
 * @author sudhir
 *         Date:11/12/16
 *         Time:5:49 PM
 *         Project:testing-spring-boot-applications
 */
@Component
public class UserVehicleService {

    private final UserRepository userRepository;

    private final VehicleDetailsService vehicleDetailsService;

    @Autowired
    public UserVehicleService(UserRepository userRepository, VehicleDetailsService vehicleDetailsService) {
        this.userRepository = userRepository;
        this.vehicleDetailsService = vehicleDetailsService;
    }

    public VehicleDetails getVehicleDetails(String username)
            throws UserNameNotFoundException,
            VehicleIdentificationNumberNotFoundException {
        Assert.notNull(username, "Username must not be null");
        User user = this.userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNameNotFoundException(username);
        }
        return this.vehicleDetailsService.getVehicleDetails(user.getVin());
    }
}
