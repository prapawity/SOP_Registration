package com.oauthsecure.secure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAuthorizationServer
public class SecureApplication  {

    public static void main(String[] args) {
        SpringApplication.run(SecureApplication.class, args);
    }

}
