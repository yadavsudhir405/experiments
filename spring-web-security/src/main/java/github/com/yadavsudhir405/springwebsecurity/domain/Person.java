package github.com.yadavsudhir405.springwebsecurity.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * @author sudhir
 *         Date:15/3/17
 *         Time:11:22 AM
 *         Project:spring-web-security
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Convert(converter = GenderConverter.class)
    private Gender gender;

    @ManyToOne()
    //@JoinColumn(name = "address_id",foreignKey = @ForeignKey(name="ADDRESS_ID_FK") )
    @JoinTable(name="Person_Address_Mapping",joinColumns = @JoinColumn(name = "address_d"),inverseJoinColumns =
    @JoinColumn(name = "person_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Address address;

    protected Person(){

    }
    public Person(@JsonProperty(value = "name") String name, @JsonProperty(value = "address")Address address,
                  @JsonProperty(value = "gender") Gender
            gender){
        this.name=name;
        this.address=address;
        this.gender=gender;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    //This property will be ignored if it's null
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Address getAddress() {
        return address;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != null ? !id.equals(person.id) : person.id != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return address != null ? address.equals(person.address) : person.address == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    public static class GenderConverter implements AttributeConverter<Gender,Character>{

        @Override
        public Character convertToDatabaseColumn(Gender attribute) {
            return attribute.getCode();
        }

        @Override
        public Gender convertToEntityAttribute(Character dbData) {
            return Gender.fromChar(dbData);
        }
    }
}
