package github.com.yadavsudhir405.springwebsecurity.constants;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

/**
 * @author sudhir
 *         Date:3/5/17
 *         Time:3:47 PM
 *         Project:spring-web-security
 */
public class DaysSerializer extends StdSerializer<Days> {


    public DaysSerializer(){
        super(Days.class);
    }
    protected DaysSerializer(Class<Days> t) {
        super(t);
    }

    @Override
    public void serialize(Days days, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("name");
        jsonGenerator.writeString(days.getName());
        jsonGenerator.writeFieldName("value");
        jsonGenerator.writeNumber(days.getValue());
        jsonGenerator.writeEndObject();
    }
}
