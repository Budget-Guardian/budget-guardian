package com.project.budgetguardian.Servicios;

import com.project.budgetguardian.Entidades.Empleado;
import com.project.budgetguardian.Entidades.Empresa;
import com.project.budgetguardian.Repositorios.EmpresaRepositorio;
import com.project.budgetguardian.Repositorios.UsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServicio {

    @Autowired
    private final EmpresaRepositorio repositorio;

    public EmpresaServicio(EmpresaRepositorio repositorio){
        this.repositorio = repositorio;
    }

    // El sistema permite consultar todas las empresas
    public List<Empresa> getEnterprises(){
        return this.repositorio.findAll();
    }

    // El sistema permite consultar una sola empresa
    public Empresa getEnterpriseByID(Long id) throws Exception {
        Optional<Empresa> empresaOptional = this.repositorio.findById(id);
        if (empresaOptional.isPresent()) {
            return empresaOptional.get();
        } else {
            throw new Exception("Empresa No Existe");
        }
    }

    // El sistema permite crear una empresa
    public Empresa createEnterprise(Empresa newEnterprise) {
        return this.repositorio.save(newEnterprise);
    }

    // El sistema permite editar una empresa
    public Empresa updateEnterpriseByID(Empresa enterprise) throws Exception {
        try {
            Empresa enterpriseDB = getEnterpriseByID(enterprise.getId());
            if (enterprise.getNombreEmpresa() != null) {
                enterprise.setNombreEmpresa(enterprise.getNombreEmpresa());
            }
            if (enterprise.getDireccion() != null) {
                enterprise.setDireccion(enterprise.getDireccion());
            }
            if (enterprise.getTelefono() != null) {
                enterprise.setTelefono(enterprise.getTelefono());
            }
            if (enterprise.getNit() != null) {
                enterprise.setNit(enterprise.getNit());
            }
            return createEnterprise(enterpriseDB);
        } catch (Exception e) {
            throw new Exception("Empresa no se actualizo, error en repositorio");
        }
    }

    // El sistema permite eliminar una empresa
    public Empresa deleteEnterpriseByID(Long id) throws Exception {
        Empresa enterprise = getEnterpriseByID(id);
        this.repositorio.deleteById(id);
        return enterprise;
    }
}