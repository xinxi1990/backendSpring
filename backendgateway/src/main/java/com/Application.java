package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.factory.StripPrefixGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class Application {





//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(p -> p
//                        .path("/get")
//                        .filters(f -> f.addRequestHeader("Hello", "World"))
//                        .uri("http://127.0.0.1:8005/apk"))
//                .build();
//    }


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
        System.out.println(String.format("##################### get getcity %s #####################", String.valueOf(postCount)));
        postCount ++;
        String resultString = "{\"result\":" + postCount  + "}";
        return resultString;
    }


}
