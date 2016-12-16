package test.sudhir.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author sudhir
 *         Date:11/12/16
 *         Time:4:06 PM
 *         Project:testing-spring-boot-applications
 */
@Converter(autoApply = true)
public class VehicleIdentificationNumberAttributeConverter implements AttributeConverter<VehicleIdentificationNumber, String> {
    @Override
    public String convertToDatabaseColumn(VehicleIdentificationNumber attribute) {
        return attribute.toString();
    }

    @Override
    public VehicleIdentificationNumber convertToEntityAttribute(String dbData) {
        return new VehicleIdentificationNumber(dbData);
    }
}
