package github.com.yadavsudhir405.springwebsecurity.domain;

import javax.persistence.*;

/**
 * @author sudhir
 *         Date:15/3/17
 *         Time:11:20 AM
 *         Project:spring-web-security
 */
@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String source;
    private String destination;
    @OneToOne()
    private Person person;

    public Reservation() {
    }

    public Long getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", person=" + person +
                '}';
    }
}
