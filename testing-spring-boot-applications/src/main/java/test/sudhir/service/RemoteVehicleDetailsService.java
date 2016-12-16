package test.sudhir.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import test.sudhir.domain.VehicleIdentificationNumber;

/**
 * @author sudhir
 *         Date:11/12/16
 *         Time:4:09 PM
 *         Project:testing-spring-boot-applications
 */
@Service
public class RemoteVehicleDetailsService implements VehicleDetailsService {

    private static final Logger logger = LoggerFactory
            .getLogger(RemoteVehicleDetailsService.class);

    private final RemoteVehicleDetailsServiceProperties properties;

    private final RestTemplate restTemplate;

    public RemoteVehicleDetailsService(RemoteVehicleDetailsServiceProperties properties,
                                       RestTemplateBuilder restTemplateBuilder) {
        this.properties = properties;
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public VehicleDetails getVehicleDetails(VehicleIdentificationNumber vin)
            throws VehicleIdentificationNumberNotFoundException {
        Assert.notNull(vin, "VIN must not be null");
        String url = this.properties.getRootUrl() + "vehicle/{vin}/details";
        logger.debug("Retrieving vehicle data for: " + vin + " from: " + url);
        try {
            return this.restTemplate.getForObject(url, VehicleDetails.class, vin);
        }
        catch (HttpStatusCodeException ex) {
            if (HttpStatus.NOT_FOUND.equals(ex.getStatusCode())) {
                throw new VehicleIdentificationNumberNotFoundException(vin, ex);
            }
            throw ex;
        }
    }
}
