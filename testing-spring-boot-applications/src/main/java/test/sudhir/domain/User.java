package test.sudhir.domain;

import org.springframework.util.Assert;

import javax.persistence.*;

/**
 * @author sudhir
 *         Date:11/12/16
 *         Time:4:01 PM
 *         Project:testing-spring-boot-applications
 */
@Entity(name = "VehicleUser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private VehicleIdentificationNumber vin;

    public User() {
    }

    public User(String username, VehicleIdentificationNumber vin) {

        Assert.hasLength(username, "Username must not be empty");
        Assert.notNull(vin, "VIN must not be null");
        this.username = username;
        this.vin = vin;
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public VehicleIdentificationNumber getVin() {
        return this.vin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        return vin != null ? vin.equals(user.vin) : user.vin == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (vin != null ? vin.hashCode() : 0);
        return result;
    }
}
