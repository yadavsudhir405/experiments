package test.sudhir.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author sudhir
 *         Date:11/12/16
 *         Time:5:41 PM
 *         Project:testing-spring-boot-applications
 */

@Component
@ConfigurationProperties(prefix = "vehicle.service")
public class RemoteVehicleDetailsServiceProperties {

    private String rootUrl = "http://localhost:8085/";

    public String getRootUrl() {
        return this.rootUrl;
    }

    public void setRootUrl(String vehicleServiceRootUrl) {
        this.rootUrl = vehicleServiceRootUrl;
    }
}
