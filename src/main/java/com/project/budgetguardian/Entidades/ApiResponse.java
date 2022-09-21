package com.project.budgetguardian.Entidades;

public class ApiResponse {
    private String mensaje;
    private Object object;

    public ApiResponse(String mensaje, Object object) {
        this.mensaje = mensaje;
        this.object = object;
    }

    public ApiResponse() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
