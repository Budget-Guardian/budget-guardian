package com.project.budgetguardian.Controladores;

import com.project.budgetguardian.Entidades.ApiResponse;
import com.project.budgetguardian.Entidades.Empleado;
import com.project.budgetguardian.Servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuariosControlador {
    @Autowired
    private final UsuarioServicio servicio;


    public UsuariosControlador(UsuarioServicio servicio) {
        this.servicio = servicio;
    }

    // El sistema permite consultar todos los usuarios
    @GetMapping("/users")
    public ResponseEntity<ApiResponse> ListaUsuarios() {
        try {
            return new ResponseEntity<>(
                    new ApiResponse("Lista de usuarios", this.servicio.getUsers()),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), null),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    // El sistema permite consultar un solo usuario
    @GetMapping("/user/{id}")
    public ResponseEntity<ApiResponse> DetalleUsuarioPorID(@PathVariable("id") Long id) {
        try {
            Empleado empleado = this.servicio.getUserByID(id);
            return new ResponseEntity<>(new ApiResponse("Listar usuario", empleado),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), null),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    // El sistema permite crear un usuario
    @PostMapping(path = "/users")
    public ResponseEntity<ApiResponse> CrearUsuario(@RequestBody Empleado user) {
        try {
            Empleado empleado = this.servicio.createUser(user);
            return new ResponseEntity<>(new ApiResponse("Usuario creado", empleado),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), null),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    // El sistema permite editar un usuario
    @PatchMapping("/user/{id}")
    public ResponseEntity<ApiResponse> ActualizarUsuarioPorID(@PathVariable("id") Long id, @RequestBody Empleado user) {
        user.setId(id);
        try {
            Empleado empleado = this.servicio.updateUserByID(user);
            return new ResponseEntity<>(new ApiResponse("Usuario actualizado", empleado),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), null),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    // El sistema permite eliminar un usuario
    @DeleteMapping("/user/{id}")
    public ResponseEntity<ApiResponse> EliminarUsuarioPorID(@PathVariable("id") Long id) {
        try {
            Empleado empleado = this.servicio.deleteUserByID(id);
            return new ResponseEntity<>(new ApiResponse("Empleado eliminado", empleado),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), null),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
