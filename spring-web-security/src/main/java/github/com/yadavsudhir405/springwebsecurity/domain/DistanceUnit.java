package github.com.yadavsudhir405.springwebsecurity.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * @author sudhir
 *         Date:3/5/17
 *         Time:12:46 PM
 *         Project:spring-web-security
 */
public enum DistanceUnit {
    KILOMETER("Kilometer",1000.0),
    MILE("Mile",1630.5),
    METER("Meter",1);

    private final double value;
    private final String unit;

    private DistanceUnit(String unit, double value) {
        this.unit = unit;
        this.value=value;
    }

    @JsonCreator
    public static DistanceUnit fromString(String distanceUnit){
        Objects.requireNonNull(distanceUnit);
        if(distanceUnit.equalsIgnoreCase("Kilometer")){
            return KILOMETER;
        }else if(distanceUnit.equalsIgnoreCase("Mile")){
            return MILE;
        }else if(distanceUnit.equalsIgnoreCase("Meter")){
            return METER;
        }else{
            throw new RuntimeException("Invalid");
        }
    }

    @JsonValue
    public String getCode(){
        return unit;
    }
    public double gerValue(){
        return value;
    }
}
