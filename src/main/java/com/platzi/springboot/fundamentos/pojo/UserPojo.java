package com.platzi.springboot.fundamentos.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "user")
public class UserPojo {
    private String name;

}
