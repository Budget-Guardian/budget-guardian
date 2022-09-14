package com.project.budgetguardian.Controladores;

import antlr.collections.List;
import com.project.budgetguardian.Entidades.Empresa;
import com.project.budgetguardian.Servicios.EmpresaServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontControlador {

    EmpresaServicio servicio;

    public FrontControlador(EmpresaServicio servicio){
        this.servicio = servicio;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/enterprises")
    public String enterprises(Model model){
        List<Empresa> empresas = this.servicio.getEmpresas();
        model.addAttribute("empresas", empresas);
        return "enterprises";
    }
}
