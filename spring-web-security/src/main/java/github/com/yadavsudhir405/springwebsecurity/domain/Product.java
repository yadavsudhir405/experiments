package github.com.yadavsudhir405.springwebsecurity.domain;

import github.com.yadavsudhir405.springwebsecurity.constants.Days;

import javax.persistence.*;

/**
 * @author sudhir
 *         Date:3/5/17
 *         Time:4:42 PM
 *         Project:spring-web-security
 */
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Days days;
    protected Product(){

    }
    public Product(String name, Days days) {
        this.name = name;
        this.days = days;
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
}
