package com.project.budgetguardian.Controladores;

import com.project.budgetguardian.Entidades.Empleado;
import com.project.budgetguardian.Servicios.UsuarioServicio;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseStatus(HttpStatus.OK)
public class UsuariosControlador {
    UsuarioServicio servicio;

    public UsuariosControlador(UsuarioServicio servicio) {
        this.servicio = servicio;
    }

    // El sistema permite consultar todos los usuarios
    @GetMapping("/users")
    public List<Empleado> ListaUsuarios() {
        return this.servicio.getUsers();
    }

    // El sistema permite consultar un solo usuario
    @GetMapping("/user/{id}")
    public Empleado DetalleUsuarioPorID(@PathVariable("id") Long id) {
        return this.servicio.getUserByID(id);
    }

    // El sistema permite crear un usuario
    @PostMapping("/users")
    public Empleado CrearUsuario(@RequestBody Empleado user) {
        return this.servicio.createUser(user);
    }

    // El sistema permite editar un usuario
    @PatchMapping("/user/{id}")
    public String ActualizarUsuarioPorID(@PathVariable("id") Long id, @RequestBody Empleado user) {
        user.setId(id);
        this.servicio.updateUserByID(user);
        return "Usuario actualizado";
    }

    // El sistema permite eliminar un usuario
    @DeleteMapping("/user/{id}")
    public String EliminarUsuarioPorID(@PathVariable("id") Long id) {
        this.servicio.deleteUserByID(id);
        return "Usuario eliminado";
    }
}
