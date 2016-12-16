package test.sudhir.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import test.sudhir.service.VehicleDetails;
import test.sudhir.service.VehicleIdentificationNumberNotFoundException;

/**
 * @author sudhir
 *         Date:11/12/16
 *         Time:5:51 PM
 *         Project:testing-spring-boot-applications
 */
@RestController
public final class UserVehicleController {

    private final  UserVehicleService userVehicleService;

    @Autowired
    public UserVehicleController(UserVehicleService userVehicleService) {
        this.userVehicleService = userVehicleService;
    }

    @GetMapping(path = "/{username}/vehicle", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getVehicleDetailsText(@PathVariable String username) {
        VehicleDetails details = this.userVehicleService.getVehicleDetails(username);
        return details.getMake() + " " + details.getModel();
    }

    @GetMapping(path = "/{username}/vehicle", produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleDetails VehicleDetailsJson(@PathVariable String username) {
        return this.userVehicleService.getVehicleDetails(username);
    }

    @GetMapping(path = "/{username}/vehicle.html", produces = MediaType.TEXT_HTML_VALUE)
    public String VehicleDetailsHtml(@PathVariable String username) {
        VehicleDetails details = this.userVehicleService.getVehicleDetails(username);
        String makeAndModel = details.getMake() + " " + details.getModel();
        return "<html><body><h1>" + makeAndModel + "</h1></body></html>";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void handleVinNotFounfException(VehicleIdentificationNumberNotFoundException e){

    }
}
