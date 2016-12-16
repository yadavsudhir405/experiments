package test.sudhir.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sudhir
 *         Date:3/12/16
 *         Time:1:56 AM
 *         Project:config-clinet
 */
@RestController
public class TestProprtyController {

    @Value("${greeting}")
    private String greeting;

    @GetMapping("value")
    public String getValue(){
        return greeting;
    }
}
