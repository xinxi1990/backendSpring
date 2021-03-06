package com.app.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/***
 * 自定义属性
 */

@Component
public class NeoProperties {

    @Value("${com.neo.title}")
    private String title;
    @Value("${com.neo.description}")
    private String description;

    //省略getter settet方法


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

