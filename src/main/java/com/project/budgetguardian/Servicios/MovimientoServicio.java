package com.project.budgetguardian.Servicios;

import com.project.budgetguardian.Entidades.Empleado;
import com.project.budgetguardian.Entidades.Empresa;
import com.project.budgetguardian.Entidades.Movimiento;
import com.project.budgetguardian.Repositorios.MovimientosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoServicio {
    @Autowired
    EmpresaServicio empresaServicio;
    @Autowired
    UsuarioServicio usuarioServicio;
    @Autowired
    private final MovimientosRepositorio repositorio;

    public MovimientoServicio(MovimientosRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    // El sistema permite consultar todos los movimientos
    public List<Movimiento> getMovements() {
        return this.repositorio.findAll();
    }

    // El sistema permite consultar un solo movimiento
    public Movimiento getMovementByID(Long id) throws Exception {
        Optional<Movimiento> MovimientoOptional = this.repositorio.findById(id);
        if (MovimientoOptional.isPresent()) {
            return MovimientoOptional.get();
        } else {
            throw new Exception("Movimiento No Existe");
        }
    }

    // El sistema permite crear un movimiento
    public Movimiento createMovement(Movimiento newMovimento) throws Exception {
        Empresa empresaDB = empresaServicio.getEnterpriseByID(newMovimento.getEmpresa().getId());
        Empleado usuarioDB = usuarioServicio.getUserByID(newMovimento.getEmpleado().getId());
        newMovimento.setEmpleado(usuarioDB);
        newMovimento.setEmpresa(empresaDB);
        return this.repositorio.save(newMovimento);
    }

    // El sistema permite editar un movimiento
    public Movimiento updateMovementByID(Movimiento movimiento) throws Exception {
        try {
            Movimiento movimientoDB = getMovementByID(movimiento.getId());
            if (movimiento.getConcept() != null) {
                movimientoDB.setConcept(movimiento.getConcept());
            }
            if (movimiento.getAmount() != null) {
                movimientoDB.setAmount(movimiento.getAmount());
            }
            if (movimiento.getCreatedAt() != null) {
                movimientoDB.setCreatedAt(movimiento.getCreatedAt());
            }
            if (movimiento.getUpdatedAt() != null) {
                movimientoDB.setUpdatedAt(movimiento.getUpdatedAt());
            }
            if (movimiento.getEmpresa() != null) {
                Empresa empresaDB = empresaServicio.getEnterpriseByID(movimiento.getEmpresa().getId());
                movimientoDB.setEmpresa(empresaDB);
            }
            if (movimiento.getEmpleado() != null){
                Empleado usuarioDB = usuarioServicio.getUserByID(movimiento.getEmpleado().getId());
                movimientoDB.setEmpleado(usuarioDB);
            }
            return createMovement(movimientoDB);
        } catch (Exception e) {
            throw new Exception("Usuario no se actualizo, error en repositorio");
        }
    }

    // El sistema permite eliminar un movimiento
    public Movimiento deleteMovementByID(Long id) throws Exception {
        Movimiento movimiento = getMovementByID(id);
        this.repositorio.deleteById(id);
        return movimiento;
    }
}
