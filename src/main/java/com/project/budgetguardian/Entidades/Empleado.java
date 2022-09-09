package com.project.budgetguardian.Entidades;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String correo;
    @Column
    private String nombre;
    @Column
    private String rol;
    @Column
    private String image;
    @Column
    private String phone;
    @Column
    private Date createdAt;
    @Column
    private Date updatedAt;

    @OneToMany(mappedBy ="empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Movimiento> movimientos;

    @ManyToOne(fetch= FetchType.LAZY, optional = false)
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    public Empleado(){
    }

    public Empleado(Long id, String correo, String nombre, String rol, String image, String phone, Date createdAt, Date updatedAt, List<Movimiento> movimientos, Empresa empresa) {
        this.id = id;
        this.correo = correo;
        this.nombre = nombre;
        this.rol = rol;
        this.image = image;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.movimientos = movimientos;
        this.empresa = empresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}