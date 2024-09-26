package me.sonminseo.foodiebuddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class FoodieBuddyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodieBuddyServerApplication.class, args);
    }

}
