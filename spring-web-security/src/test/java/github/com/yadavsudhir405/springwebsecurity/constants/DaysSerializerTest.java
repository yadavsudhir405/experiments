package github.com.yadavsudhir405.springwebsecurity.constants;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;

/**
 * @author sudhir
 *         Date:3/5/17
 *         Time:5:30 PM
 *         Project:spring-web-security
 */
public class DaysSerializerTest {
    @org.junit.Test
    public void serializeWithDaysShouldReturnProperString() throws JsonProcessingException, JSONException {
        Days days=Days.MONTH;
        String expectedString="{\n" +
                "  \"name\":\"Month\",\n" +
                "  \"value\":30\n" +
                "}";
        ObjectMapper objectMapper=new ObjectMapper();
        SimpleModule simpleModule=new SimpleModule();
        simpleModule.addSerializer(Days.class,new DaysSerializer());
        objectMapper.registerModule(simpleModule);
        String receivedString=objectMapper.writeValueAsString(days);
        JSONAssert.assertEquals(expectedString,receivedString,false);
    }
}
