package com.project.budgetguardian.Servicios;

import com.project.budgetguardian.Entidades.Empresa;
import com.project.budgetguardian.Repositorios.EmpresaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServicio {
    private EmpresaRepositorio repositorio;

    public EmpresaServicio(EmpresaRepositorio repositorio){
        this.repositorio = repositorio;
    }

    public List<Empresa> getEmpresas(){
        return this.repositorio.findAll();
    }

    public Empresa getEmpresa(Long id){
        return this.repositorio.findById(id).get();
    }

    public Empresa createEmpresa(Empresa nuevaEmpresa){
        return this.repositorio.save(nuevaEmpresa);
    }

    public void updateEmpresa(Empresa empresa){
        this.repositorio.save(empresa);
    }

    public void deleteEmpresa(Long id){
        this.repositorio.deleteById(id);
    }
}