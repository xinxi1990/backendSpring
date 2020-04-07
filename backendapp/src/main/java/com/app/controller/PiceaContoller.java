package com.app.controller;

import com.app.property.NeoProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/query")
public class PiceaContoller {


    @Autowired
    NeoProperties neoProperties;

    @GetMapping(path="/ping")
    public @ResponseBody String ping() {
        return neoProperties.getDescription();
    }

    @GetMapping(path="/task")
    public @ResponseBody String asyncTask() throws Exception {
        System.out.println("我是控制类里面的方法，我正在思考...............");
        return "asyncTask ==>";
    }

}
