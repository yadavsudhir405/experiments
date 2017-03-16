package test.sudhir.web;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "UserVehicleService",description = "This is user Vehicle service",produces = "application/json")
public final class UserVehicleController {

    private final  UserVehicleService userVehicleService;

    @Autowired
    public UserVehicleController(UserVehicleService userVehicleService) {
        this.userVehicleService = userVehicleService;
    }
    @ApiOperation(value = "getUserVehicle", nickname = "getUserVehicleTextPlain",response = String.class)
    @GetMapping(path = "/{username}/vehicle", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getVehicleDetailsText(@PathVariable String username) {
        VehicleDetails details = this.userVehicleService.getVehicleDetails(username);
        return details.getMake() + " " + details.getModel();
    }
    @ApiOperation(value = "getUserVehicleAsJson", nickname = "getUserVehicleJsonValue",response = VehicleDetails.class)
    @GetMapping(path = "/{username}/vehicle", produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleDetails VehicleDetailsJson(@PathVariable String username) {
        return this.userVehicleService.getVehicleDetails(username);
    }

    @ApiOperation(value = "getUserVehicleAsHtml", nickname = "getUserVehicleHtmlValue",response = String.class)
    @GetMapping(path = "/{username}/vehicle.html", produces = MediaType.TEXT_HTML_VALUE)
    public String VehicleDetailsHtml(@PathVariable String username) {
        VehicleDetails details = this.userVehicleService.getVehicleDetails(username);
        String makeAndModel = details.getMake() + " " + details.getModel();
        return "<html><body><h1>" + makeAndModel + "</h1></body></html>";
    }



    @ApiOperation(value = "getMeDtails", nickname = "getMeDtails",response = VehicleDetails.class)
    @GetMapping(path = "getMeDtails",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public VehicleDetails getDetails(){
        return new VehicleDetails("Honda","Civic");
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void handleVinNotFounfException(VehicleIdentificationNumberNotFoundException e){

    }
}
