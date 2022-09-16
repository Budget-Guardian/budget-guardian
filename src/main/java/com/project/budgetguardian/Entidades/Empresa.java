package com.project.budgetguardian.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column
    private String nombreEmpresa;
    @Column
    private String direccion;
    @Column
    private String telefono;
    @Column
    private String nit;

    @JsonIgnore
    @OneToMany(mappedBy = "empresa")
    private List<Empleado> empleados;

    @JsonIgnore
    @OneToMany(mappedBy = "empresa")
    private List<Movimiento> movimientos;

    public Empresa(Long id, String nombreEmpresa, String direccion, String telefono, String nit) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;
    }

    public Empresa(){
        this.nombreEmpresa = "Empresa por defecto";
        this.direccion = "Dirección por defecto";
        this.telefono = "Telefono por defecto";
        this.nit = "Nit por defecto";
        this.id = Long.valueOf(1);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

}
