package com.project.budgetguardian.Controladores;

import com.project.budgetguardian.Entidades.Empleado;
import com.project.budgetguardian.Repositorios.UsuariosRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseStatus(HttpStatus.OK)
public class UsuariosControlador {
    private final UsuariosRepositorio servicio;

    public UsuariosControlador(UsuariosRepositorio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/users")
    public List<Empleado> ListaUsuarios() {
        return servicio.findAll();
    }

    @PostMapping("/users")
    public String CrearUsuarios(){
        return "POST creación de usuarios";
    }

    @GetMapping("/user/{id}")
    public String DetalleUsuarioPorID(){
        return "GET detalle de usuario por ID";
    }

    @PatchMapping("/user/{id}")
    public String ActualizarUsuarioPorID(){
        return "PATCH Actualización de usuario por ID";
    }

    @DeleteMapping("/user/{id}")
    public String EliminarUsuarioPorID(){
        return "DELETE Eliminación de usuario por ID";
    }
}
