package com.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaClient
@RestController
public class Application {



    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Value("${server.port}")
    String port;

    public int postCount = 0 ;


    @GetMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "zhangsan") String name) {
        System.out.println("##################### get requests #####################");
        return "hi " + name + " ,i am from port:" + port;
    }

    @GetMapping("/getcity")
    public String getlist(@RequestParam(value = "name", defaultValue = "beijing") String name) {
        System.out.println(String.format("##################### get getcity % % #####################", name + postCount));
        postCount ++;
        String resultString = "{\"result\":" + name + postCount  + "}";
        return resultString;
    }

}
