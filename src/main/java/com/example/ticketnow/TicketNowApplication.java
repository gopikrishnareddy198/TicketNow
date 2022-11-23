package com.example.ticketnow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
public class TicketNowApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketNowApplication.class, args);
    }

}
