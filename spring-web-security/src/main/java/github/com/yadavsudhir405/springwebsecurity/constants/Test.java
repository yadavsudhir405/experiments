package github.com.yadavsudhir405.springwebsecurity.constants;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;

/**
 * @author sudhir
 *         Date:3/5/17
 *         Time:3:56 PM
 *         Project:spring-web-security
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Days days=Days.MONTH;
        String str=new ObjectMapper().writeValueAsString(days);
        System.out.println(str);
        Days days1=new ObjectMapper().readValue(str,Days.class);
        SimpleModule simpleModule=new SimpleModule();
        simpleModule.addSerializer(Days.class,new DaysSerializer());
        simpleModule.addDeserializer(Days.class,new DaysDeserializer());
    }
}
