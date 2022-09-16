package com.project.budgetguardian.Entidades;
import java.util.Date;

import javax.persistence.*;

/**
 * Movimiento
 */
@Entity
@Table(name="Movimento")
public class Movimiento {
    // ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String concept;
    @Column
    private Float amount;
    @Column
    private Date createdAt;
    @Column
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;


    // MÉTODOS
    // Constructor

    public Movimiento(Long id, String concept, Float amount, Date createdAt, Date updatedAt) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Movimiento(){
        this.id = Long.valueOf(1);
        this.concept = "Transaction";
        this.amount = Float.valueOf(1450000);
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    // Getter Y Setter
    public Long getId() {
        return id;
    }

    public String getConcept() {
        return concept;
    }

    public Float getAmount() {
        return amount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}