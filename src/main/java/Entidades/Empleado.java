package Entidades;
import javax.persistence.*;
@Entity;
public class Empleado {
    private  string correo;
    private  string Empresa;
    private  string rol;
    //@OneToMany(mappedBy = "Empleado");
    //private list <>

    public Empleado(string correo, string empresa, string rol, string nombreEmpleado) {
        this.correo = correo;
        Empresa = empresa;
        this.rol = rol;
        this.nombreEmpleado = nombreEmpleado;
    }

    public Empleado(){
        this.correo = "correo por defecto";
        Empresa = "empresa por defecto";
        this.rol = "rol por defecto";
        this.nombreEmpleado = "nombreEmpleado por defecto";

    }

    @GeneratedValue(strategy =generationType.Auto)
    private  string nombreEmpleado;

    public string getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(string nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public string getCorreo() {
        return correo;
    }

    public void setCorreo(string correo) {
        this.correo = correo;
    }

    public string getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(string empresa) {
        Empresa = empresa;
    }

    public string getRol() {
        return rol;
    }

    public void setRol(string rol) {
        this.rol = rol;
    }






}
