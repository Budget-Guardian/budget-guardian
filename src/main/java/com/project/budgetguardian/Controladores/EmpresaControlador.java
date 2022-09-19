package com.project.budgetguardian.Controladores;

import com.project.budgetguardian.Entidades.ApiResponse;
import com.project.budgetguardian.Entidades.Empleado;
import com.project.budgetguardian.Entidades.Empresa;
import com.project.budgetguardian.Servicios.EmpresaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmpresaControlador {
    @Autowired
    private EmpresaServicio servicio;

    public EmpresaControlador(EmpresaServicio servicio){
        this.servicio = servicio;
    }

    // El sistema permite consultar todos las empresas
    @GetMapping("/enterprises")
    public ResponseEntity<ApiResponse> ListaEmpresas() {
        try {
            return new ResponseEntity<>(
                    new ApiResponse("Lista de empresas", this.servicio.getEnterprises()),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), null),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    // El sistema permite consultar una sola empresa
    @GetMapping("/enterprise/{id}")
    public ResponseEntity<ApiResponse> DetalleEmpresaPorID(@PathVariable("id") Long id) {
        try {
            Empresa empresa = this.servicio.getEnterpriseByID(id);
            return new ResponseEntity<>(new ApiResponse("Listar empresa", empresa),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), null),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    // El sistema permite crear una empresa
    @PostMapping(path = "/enterprises")
    public ResponseEntity<ApiResponse> CrearEmpresa(@RequestBody Empresa enterprise) {
        try {
            Empresa empresa = this.servicio.createEnterprise(enterprise);
            return new ResponseEntity<>(new ApiResponse("Empresa creada", enterprise),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), null),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    // El sistema permite editar una empresa
    @PatchMapping("/enterprise/{id}")
    public ResponseEntity<ApiResponse> ActualizarEmpresaPorID(@PathVariable("id") Long id, @RequestBody Empresa enterprise) {
        enterprise.setId(id);
        try {
            Empresa empresa = this.servicio.updateEnterpriseByID(enterprise);
            return new ResponseEntity<>(new ApiResponse("Empresa actualizada", empresa),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), null),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    // El sistema permite eliminar una empresa
    @DeleteMapping("/enterprise/{id}")
    public ResponseEntity<ApiResponse> EliminarEmpresaPorID(@PathVariable("id") Long id) {
        try {
            Empresa empresa = this.servicio.deleteEnterpriseByID(id);
            return new ResponseEntity<>(new ApiResponse("Empleado eliminado", empresa),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), null),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
