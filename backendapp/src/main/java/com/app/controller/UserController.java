package com.app.controller;

import java.util.ArrayList;
import java.util.List;
import com.app.server.Userimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    Userimpl userimpl;


    @ResponseBody
    @RequestMapping("/get")
    public List<String> get(){
        List<String> list = new ArrayList<String>();
        for(int i = 0 ; i < 5 ; i++){
            list.add(i + "");
        }
        return list;
    }

    @ResponseBody
    @RequestMapping("/exception")
    public List<String> exception(){
        List<String> list = new ArrayList<String>();
        for(int i = 0 ; i < 5 ; i++){
            if(i == 3){
                throw new RuntimeException("error");
            }
            list.add(i + "");
        }
        return list;
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println(name);
        String resultString = "{\"result\":" + String.format("Hello %s!", name)  + "}";
        return resultString;
    }

    @ResponseBody
    @RequestMapping("/getusername")
    public String getUserName(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println(name);
        String userName = userimpl.getUserName(name);
        return userName;
    }



}