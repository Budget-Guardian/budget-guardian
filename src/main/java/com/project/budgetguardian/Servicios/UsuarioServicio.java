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

    public List<Empleado> getUsuarios() {
        return this.repositorio.findAll();
    }
}
