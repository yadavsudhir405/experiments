package github.com.yadavsudhir405.springwebsecurity.domain;

import github.com.yadavsudhir405.springwebsecurity.constants.DistanceUnit;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author sudhir
 *         Date:3/5/17
 *         Time:12:51 PM
 *         Project:spring-web-security
 */
@Embeddable
public class DistanceTravelled {

    @Enumerated(EnumType.STRING)
    private DistanceUnit distance;
    private  double value;

    protected DistanceTravelled(){

    }
    public DistanceTravelled(DistanceUnit distance, double value) {
        this.distance = distance;
        this.value = value;
    }

    public DistanceUnit getDistance() {
        return distance;
    }

    public double getValue() {
        return value;
    }
}
