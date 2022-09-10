package com.project.budgetguardian.Servicios;

import com.project.budgetguardian.Entidades.Empleado;
import com.project.budgetguardian.Repositorios.UsuariosRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio {
    private UsuariosRepositorio repositorio;

    public UsuarioServicio(UsuariosRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    // El sistema permite consultar todos los usuarios
    public List<Empleado> getUsers() {
        return this.repositorio.findAll();
    }

    // El sistema permite consultar un solo usuario
    public Empleado getUserByID(Long id){
        return this.repositorio.findById(id).get();
    }

    // El sistema permite crear un usuario
    public Empleado createUser(Empleado newUser){
        return this.repositorio.save(newUser);
    }

    // El sistema permite editar un usuario
    public void updateUserByID(Empleado user){
        this.repositorio.save(user);
    }

    // El sistema permite eliminar un usuario
    public void deleteUserByID(Long id){
        this.repositorio.deleteById(id);
    }
}
