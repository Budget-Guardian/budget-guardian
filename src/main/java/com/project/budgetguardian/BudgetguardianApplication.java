package com.project.budgetguardian;

import com.project.budgetguardian.Entidades.Empleado;
/*import Entidades.Empresa;
import Entidades.Movimiento;*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BudgetguardianApplication {

    @GetMapping("/hello")
    public String hello(){
        return "Hola Mundo!";
    }

    public static void main(String[] args) {
        SpringApplication.run(BudgetguardianApplication.class, args);
    }
}
