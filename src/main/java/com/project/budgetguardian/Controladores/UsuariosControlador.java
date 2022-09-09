package com.project.budgetguardian.Controladores;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseStatus(HttpStatus.OK)
public class UsuariosControlador {
    @GetMapping("/users")
    public String ListaUsuarios(){
        return "GET lista de usuarios";
    }

    @PostMapping("/users")
    public String CrearUsuarios(){
        return "POST creación de usuarios";
    }

    @GetMapping("/user/{id}")
    public String ListaUsuarioPorID(){
        return "GET lista de usuario por ID";
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
