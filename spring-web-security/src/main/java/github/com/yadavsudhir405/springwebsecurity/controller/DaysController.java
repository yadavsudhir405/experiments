package github.com.yadavsudhir405.springwebsecurity.controller;

import github.com.yadavsudhir405.springwebsecurity.constants.Days;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sudhir
 *         Date:3/5/17
 *         Time:4:20 PM
 *         Project:spring-web-security
 */
@RestController
@RequestMapping(path = "/days")
public class DaysController {

    @PostMapping
    public void displayDays(@RequestBody Days days){
        System.out.println(days.toString());
    }
}
