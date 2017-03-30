package github.com.yadavsudhir405.springwebsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sudhir
 *         Date:21/3/17
 *         Time:5:22 PM
 *         Project:spring-web-security
 */
@RestController
@RequestMapping(path = "/version")
public class ServiceCheckController {

    @GetMapping
    public String getVersion(){
        return "1.0.0";
    }
}
