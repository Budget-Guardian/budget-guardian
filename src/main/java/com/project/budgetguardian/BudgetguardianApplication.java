package com.project.budgetguardian;

import Entidades.Empleado;
import Entidades.Empresa;
import Entidades.Movimiento;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@SpringBootApplication
//@RestController
public class BudgetguardianApplication {

    public static void main(String[] args) {
        //SpringApplication.run(BudgetguardianApplication.class, args);
        System.out.println("Creando Instancia de la Empresa");
        Empresa empresa1 = new Empresa();
        System.out.println("----Modificar y leer nombre de la empresa----");
        empresa1.setNombreEmpresa("Budget Guardian");
        System.out.println("Nombre de la empresa: " + empresa1.getNombreEmpresa());
        System.out.println("----Modificar y leer direccion de la empresa----");
        empresa1.setDireccion("Carrera 68 # 4 - 16 Sur");
        System.out.println("Dirección de la empresa: " + empresa1.getDireccion());
        System.out.println("----Modificar y leer el telefono de la empresa----");
        empresa1.setTelefono("608901546");
        System.out.println("Telefono de la empresa " + empresa1.getTelefono());
        System.out.println("----Modificar y leer NIT de la empresa----");
        empresa1.setNit("459784654985-8");
        System.out.println("NIT de la empresa: "+ empresa1.getNit());

        System.out.println("==========================================");
        System.out.println("Creando Intancia de empleado");
        Empleado empleado1 = new Empleado();
        System.out.println("----Modificar y leer nombre del empleado----");
        empleado1.setNombre("Mauricio Rojas");
        System.out.println("Nombre del empleado: " + empleado1.getNombre());
        System.out.println("----Modificar y leer correo del empleado----");
        empleado1.setCorreo("mauricio@mail.com");
        System.out.println("Correo del empleado: " + empleado1.getCorreo());
        System.out.println("----Modificar y leer empresa del empleado----");
        empleado1.setEmpresa(empresa1);
        System.out.println("Empresa del empleado: " + empleado1.getEmpresa().getNombreEmpresa());
        System.out.println("----Modificar y leer rol del empleado----");
        empleado1.setRol("administrador");
        System.out.println("Rol del empleado: " + empleado1.getRol());

        System.out.println("==========================================");
        System.out.println("Creando Intancia de Movimiento (transaccion)");
        Movimiento movimiento1 = new Movimiento();
        System.out.println("----Modificar y leer el monto del movimiento----");
        movimiento1.setAmount(250000F);
        System.out.println("Monto del movimiento(positivo): " + movimiento1.getAmount());
        System.out.println("----Crear montos positivos y negativos----");
        movimiento1.setAmount(-250000F);
        System.out.println("Monto del movimiento(negativo): " + movimiento1.getAmount());
        System.out.println("----Modificar y leer el concepto del movimiento----");
        movimiento1.setConcept("Concepto de nomina");
        System.out.println("Concepto del movimiento: " + movimiento1.getConcept());
        System.out.println("----Modificar y leer el encargado de registrar el movimiento----");
        movimiento1.setEmpleado(empleado1);
        System.out.println("Empleado que realiza el movimiento: " + movimiento1.getEmpleado().getNombre());
    }
}
