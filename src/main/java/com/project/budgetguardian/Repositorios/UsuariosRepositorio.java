package com.project.budgetguardian.Repositorios;

import com.project.budgetguardian.Entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepositorio extends JpaRepository<Empleado, Long> {
}
