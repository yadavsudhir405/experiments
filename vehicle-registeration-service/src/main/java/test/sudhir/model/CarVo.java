package test.sudhir.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sudhir
 *         Date:18/12/16
 *         Time:12:54 PM
 *         Project:vehicleregisterationservice
 */
public final class CarVo {

    private  String make;

    private  String model;

    public CarVo(@JsonProperty("make") String make, @JsonProperty("model") String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarVo carVo = (CarVo) o;

        if (make != null ? !make.equals(carVo.make) : carVo.make != null) return false;
        return model != null ? model.equals(carVo.model) : carVo.model == null;

    }

    @Override
    public int hashCode() {
        int result = make != null ? make.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }
}
