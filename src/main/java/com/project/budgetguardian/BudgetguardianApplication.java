package com.project.budgetguardian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BudgetguardianApplication {
    public static void main(String[] args) {
        SpringApplication.run(BudgetguardianApplication.class, args);
    }
}
