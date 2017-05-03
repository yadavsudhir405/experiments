package github.com.yadavsudhir405.springwebsecurity.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author sudhir
 *         Date:3/5/17
 *         Time:3:41 PM
 *         Project:spring-web-security
 */
/*The following annotation has been commented out because we want to parse Month,Week to Days not the the complete tree
 as {"name":"Month","value":30}

*/

//@JsonSerialize(using = DaysSerializer.class)
//@JsonDeserialize(using = DaysDeserializer.class)
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
    @JsonValue
    public String getValueForJsonRepresentation(){
        if(this.getName().equalsIgnoreCase("month")){
            return "Month";
        }else if(this.getName().equalsIgnoreCase("year")){
            return "Year";
        }else if(this.getName().equalsIgnoreCase("Week")){
            return "Week";
        }else{
            throw new RuntimeException("Invalid");
        }
    }

    @JsonCreator
    public static Days fromString(String str){
        if(str.equalsIgnoreCase("Month")){
            return MONTH;
        }else if(str.equalsIgnoreCase("week")){
            return WEEK;
        }else if(str.equalsIgnoreCase("year")){
            return YEAR;
        }else {
            throw new RuntimeException("Invalid");
        }
    }
}

