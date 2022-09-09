package com.project.budgetguardian.Controladores;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseStatus(HttpStatus.OK)
public class EmpresaControlador {

    @GetMapping("/enterprises/{idEnt}/movements")
    public String ListaMovimientosEmpresa(){
        return "GET lista de movimientos de empresa";
    }

    @PostMapping("/enterprises/{idEnt}/movements")
    public String CrearMovimientosEmpresa(){
        return "POST creación de movimiento de empresa";
    }

    @PatchMapping("/enterprises/{idEnt}/movements/{IdMov}")
    public String ActualizarMovimientosEmpresa(){
        return "Patch Actualización de movimiento de empresa";
    }

    @DeleteMapping("/enterprises/{idEnt}/movements/{IdMov}")
    public String EliminarMovimientosEmpresa(){
        return "Patch Eliminación de movimiento de empresa";
    }



}
