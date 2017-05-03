package github.com.yadavsudhir405.springwebsecurity.constants;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.assertj.core.api.Assertions;

import java.io.IOException;

/**
 * @author sudhir
 *         Date:3/5/17
 *         Time:5:37 PM
 *         Project:spring-web-security
 */
public class DaysDeserializationTest {
    @org.junit.Test
    public void deserialize() throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        SimpleModule simpleModule=new SimpleModule();
        simpleModule.addDeserializer(Days.class,new DaysDeserializer());
        objectMapper.registerModule(simpleModule);
        String inputString="{\n" +
                "  \"name\":\"Month\",\n" +
                "  \"value\":30\n" +
                "}";
        Days expectedDays=Days.MONTH;
        Days actualDays=objectMapper.readValue(inputString,Days.class);
        Assertions.assertThat(actualDays).isEqualTo(expectedDays);

    }
}
