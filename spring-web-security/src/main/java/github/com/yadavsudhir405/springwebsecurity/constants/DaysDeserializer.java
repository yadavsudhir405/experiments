package github.com.yadavsudhir405.springwebsecurity.constants;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

/**
 * @author sudhir
 *         Date:3/5/17
 *         Time:4:04 PM
 *         Project:spring-web-security
 */
public class DaysDeserializer extends StdDeserializer<Days> {
    public DaysDeserializer(){
        super(Days.class);
    }
    DaysDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Days deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode jsonNode=jsonParser.getCodec().readTree(jsonParser);
        String name=jsonNode.get("name").asText();
        int value=jsonNode.get("value").intValue();
        if(name.equals("Month")&& value==30){
            return Days.MONTH;
        }else if(name.equalsIgnoreCase("week")&& value==7){
            return Days.WEEK;
        }else if(name.equalsIgnoreCase("year")&& value==365){
            return Days.YEAR;
        }else {
            throw new RuntimeException("Invalid");
        }
    }
}
