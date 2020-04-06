package com.app.server;
import org.springframework.stereotype.Service;

@Service
public class Userimpl implements UserService {

    @Override
    public String getUserName(String name) {
        if (name.equals("mike")){
            return "mike";
        }else {
            return "other UserService";
        }

    }

}
