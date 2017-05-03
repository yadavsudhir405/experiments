package github.com.yadavsudhir405.springwebsecurity.constants;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author sudhir
 *         Date:3/5/17
 *         Time:3:41 PM
 *         Project:spring-web-security
 */
@JsonSerialize(using = DaysSerializer.class)
@JsonDeserialize(using = DaysDeserializer.class)
public enum Days {
    WEEK("Week",7),
    MONTH("Month",30),
    YEAR("Year",365);

    private final String name;
    protected final int value;

    Days(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return name;
    }
    public int getValue(){
        return value;
    }

    @Override
    public String toString() {
        return "Days{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}

