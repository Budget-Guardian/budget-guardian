package com.project.budgetguardian.Servicios;

import com.project.budgetguardian.Entidades.Empleado;
import com.project.budgetguardian.Entidades.Empresa;
import com.project.budgetguardian.Repositorios.UsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    EmpresaServicio empresaServicio;
    @Autowired
    private final UsuariosRepositorio repositorio;

    public UsuarioServicio(UsuariosRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    // El sistema permite consultar todos los usuarios
    public List<Empleado> getUsers() {
        return this.repositorio.findAll();
    }

    // El sistema permite consultar un solo usuario
    public Empleado getUserByID(Long id) throws Exception {
        Optional<Empleado> empleadoOptional = this.repositorio.findById(id);
        if (empleadoOptional.isPresent()) {
            return empleadoOptional.get();
        } else {
            throw new Exception("Usuario No Existe");
        }
    }

    // El sistema permite crear un usuario
    public Empleado createUser(Empleado newUser) throws Exception {
        Empresa empresaDB = empresaServicio.getEnterpriseByID(newUser.getEmpresa().getId());
        newUser.setEmpresa(empresaDB);
        return this.repositorio.save(newUser);
    }

    // El sistema permite editar un usuario
    public Empleado updateUserByID(Empleado user) throws Exception {
        try {
            Empleado userDB = getUserByID(user.getId());
            if (user.getCorreo() != null) {
                userDB.setCorreo(user.getCorreo());
            }
            if (user.getNombre() != null) {
                userDB.setNombre(user.getNombre());
            }
            if (user.getRol() != null) {
                userDB.setRol(user.getRol());
            }
            if (user.getImage() != null) {
                userDB.setImage(user.getImage());
            }
            if (user.getPhone() != null) {
                userDB.setPhone(user.getPhone());
            }
            if (user.getCreatedAt() != null) {
                userDB.setCreatedAt(user.getCreatedAt());
            }
            if (user.getUpdatedAt() != null) {
                userDB.setUpdatedAt(user.getUpdatedAt());
            }
            if (user.getEmpresa() != null) {
                Empresa empresaDB = empresaServicio.getEnterpriseByID(user.getEmpresa().getId());
                userDB.setEmpresa(empresaDB);
            }
            return createUser(userDB);
        } catch (Exception e) {
            throw new Exception("Usuario no se actualizo, error en repositorio");
        }
    }

    // El sistema permite eliminar un usuario
    public Empleado deleteUserByID(Long id) throws Exception {
        Empleado user = getUserByID(id);
        this.repositorio.deleteById(id);
        return user;
    }
}
