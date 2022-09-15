package com.project.budgetguardian.Controladores;

import com.project.budgetguardian.Entidades.Empresa;
import com.project.budgetguardian.Servicios.EmpresaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseStatus(HttpStatus.OK)
public class EmpresaControlador {
    EmpresaServicio servicio;
    public EmpresaControlador(EmpresaServicio servicio){
        this.servicio = servicio;
    }
    @GetMapping("/api/enterprises")
    public List<Empresa> ListaEmpresas(){
        return this.servicio.getEmpresas();
    }

    @PostMapping("/api/enterprises")
    public Empresa CrearEmpresa(@RequestBody Empresa empresa){
        return this.servicio.createEmpresa(empresa);
    }

    @GetMapping("/api/enterprises/{id}")
    public Empresa DetalleEmpresa(@PathVariable("id") Long id){
        return this.servicio.getEmpresa(id);
    }

    @PatchMapping("/api/enterprises/{id}")
    public String ActualizarEmpresa(@PathVariable("id") Long id, @RequestBody Empresa empresa){
        empresa.setId(id);
        this.servicio.updateEmpresa(empresa);
        return "Empresa actualizada";
    }

    @DeleteMapping("/api/enterprises/{id}")
    public String EliminarEmpresa(@PathVariable("id") Long id){
        this.servicio.deleteEmpresa(id);
        return "Empresa Eliminada";
    }
}
