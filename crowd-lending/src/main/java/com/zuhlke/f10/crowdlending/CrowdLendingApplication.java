package com.zuhlke.f10.crowdlending;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.zuhlke.f10.crowdlending")
public class CrowdLendingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrowdLendingApplication.class, args);
    }
}
