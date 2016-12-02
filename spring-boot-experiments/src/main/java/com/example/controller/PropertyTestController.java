package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sudhir
 *         Date:2/12/16
 *         Time:11:50 AM
 *         Project:springbootexperiment
 */
@RestController
public class PropertyTestController {

    @Value("${greeting}")
    private String propertValue;
    @GetMapping("value")
    public String getValue() {
        return propertValue;
    }


}
