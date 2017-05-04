package github.com.yadavsudhir405.springwebsecurity.domain;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import github.com.yadavsudhir405.springwebsecurity.constants.Days;

import javax.persistence.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * The product's date input should be inthe form of "d-MMM-yyyy" from as json input and return type would be in the
 * same format.
 * @author sudhir
 *         Date:3/5/17
 *         Time:4:42 PM
 *         Project:spring-web-security
 */
@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"id","name","days","date","isIsoCertified"})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Days days;

    @JsonDeserialize(using = LocaleDateDeserializer.class)
    @JsonSerialize(using = LocaleDateSerializer.class)
    @Convert(converter =LocaleDateConverter.class )
    private LocalDate date;

    @JsonDeserialize(using = IsoCertifiedJsonDeserializer.class)
    @JsonSerialize(using = IsoCertifiedJsonSerializer.class)
    @Convert(converter = IsoCertifiedConverter.class)
    private Boolean isIsoCertified;

    //@Transient
    //@JsonIgnore
    private String ignoreMe;
    protected Product(){

    }

    @JsonCreator
    public Product(@JsonProperty(value = "name") String name,@JsonProperty(value = "days") Days days,@JsonProperty
            (value = "date")
            LocalDate
            date) {
        Objects.requireNonNull(name,"Product name can't be empty");
        Objects.requireNonNull(days,"Days can't be empty");
        Objects.requireNonNull(date,"Date name can't be empty");
        this.name = name;
        this.days = days;
        this.date=date;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Days getDays() {
        return days;
    }


    public LocalDate getDate() {
        return date;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getIsIsoCertified() {
        return isIsoCertified;
    }

    public String getIgnoreMe() {
        return ignoreMe;
    }

    public static class LocaleDateDeserializer extends StdDeserializer<LocalDate>{
        private static final DateTimeFormatter DATE_TIME_FORMATTER=DateTimeFormatter.ofPattern("d-MMM-yyyy");
        public LocaleDateDeserializer(){
            super(LocalDate.class);
        }
        public LocaleDateDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            String dateString=jsonParser.getText();
            return LocalDate.parse(dateString,DATE_TIME_FORMATTER);
        }
    }

    public static class LocaleDateSerializer extends StdSerializer<LocalDate>{
        private static final DateTimeFormatter DATE_TIME_FORMATTER=DateTimeFormatter.ofPattern("d-MMM-yyyy");
        public LocaleDateSerializer() {
            super(LocalDate.class);
        }

        public LocaleDateSerializer(Class<LocalDate> t) {
            super(t);
        }

        @Override
        public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(DATE_TIME_FORMATTER.toFormat().format(localDate));
        }
    }

    public static class LocaleDateConverter implements AttributeConverter<LocalDate,String>{
        private static final DateTimeFormatter DATE_TIME_FORMATTER=DateTimeFormatter.ofPattern("d-MMM-yyyy");
        @Override
        public String convertToDatabaseColumn(LocalDate date) {
            return DATE_TIME_FORMATTER.toFormat().format(date);
        }

        @Override
        public LocalDate convertToEntityAttribute(String dbData) {
            return LocalDate.parse(dbData,DATE_TIME_FORMATTER);
        }
    }

    public static class IsoCertifiedConverter implements AttributeConverter<Boolean,String>{

        @Override
        public String convertToDatabaseColumn(Boolean attribute) {
            return attribute==Boolean.TRUE?"Yes":"No";
        }

        @Override
        public Boolean convertToEntityAttribute(String dbData) {
            return "Yes".equalsIgnoreCase(dbData)?Boolean.TRUE:Boolean.FALSE;
        }
    }

    public static class IsoCertifiedJsonSerializer extends StdSerializer<Boolean>{
        public IsoCertifiedJsonSerializer(){
            super(Boolean.class);
        }
        protected IsoCertifiedJsonSerializer(Class<Boolean> t) {
            super(t);
        }

        @Override
        public void serialize(Boolean aBoolean, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if(aBoolean)jsonGenerator.writeString("Yes");
            else jsonGenerator.writeString("No");
        }
    }
    public static class IsoCertifiedJsonDeserializer extends StdDeserializer<Boolean>{
        public IsoCertifiedJsonDeserializer(){
            super(Boolean.class);
        }
        public IsoCertifiedJsonDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public Boolean deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            String value=jsonParser.getText();
            return ("Yes".equalsIgnoreCase(value))?Boolean.TRUE:Boolean.FALSE;
        }
    }
}
