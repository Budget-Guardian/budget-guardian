package com.project.budgetguardian.Repositorios;

import com.project.budgetguardian.Entidades.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientosRepositorio extends JpaRepository<Movimiento, Long> {
}
