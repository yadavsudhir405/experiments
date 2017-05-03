package github.com.yadavsudhir405.springwebsecurity.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author sudhir
 *         Date:3/5/17
 *         Time:11:14 AM
 *         Project:spring-web-security
 */
public enum Gender {
    MALE('M'),FEMALE('F');
    private char c;
    Gender(char c){
        this.c=c;
    }


    public char getCode(){
        return c;
    }

    @JsonValue
    public  String getString(){
        if(c=='M'){
            return "Male";
        }else if(c=='F'){
            return "Female";
        }else{
            throw new RuntimeException("Invalid");
        }
    }

    public String toString(){
        return Character.toString(c);
    }

    @JsonCreator
    public static Gender fromString(String c){
        if(c.equalsIgnoreCase("male")){
            return MALE;
        }else if(c.equalsIgnoreCase("female")){
            return FEMALE;
        }else{
            throw new RuntimeException("Invalid String");
        }
    }

    public static Gender fromChar(char c){
        switch (c){
            case 'M':
                return MALE;
            case 'F':
                return FEMALE;
            default:throw new RuntimeException("Invalid Character");
        }
    }
}
