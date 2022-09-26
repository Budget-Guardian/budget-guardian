package com.project.budgetguardian.Controladores;

import com.project.budgetguardian.Entidades.Empleado;
import com.project.budgetguardian.Entidades.Empresa;
import com.project.budgetguardian.Entidades.Movimiento;
import com.project.budgetguardian.Servicios.EmpresaServicio;
import com.project.budgetguardian.Servicios.MovimientoServicio;
import com.project.budgetguardian.Servicios.UsuarioServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FrontControlador {

    EmpresaServicio serviceCompany;
    UsuarioServicio serviceUser;
    MovimientoServicio serviceMovements;

    public FrontControlador(EmpresaServicio serviceCompany,
                            UsuarioServicio serviceUser
//                            MovimientosServicio serviceMovements
    ){
        this.serviceCompany = serviceCompany;
        this.serviceUser = serviceUser;
//        this.serviceMovements = serviceMovements;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/enterprises")
    public String enterprises(Model model){
        List<Empresa> empresas = this.serviceCompany.getEnterprises();
        model.addAttribute("empresas", empresas);
        return "enterprises";
    }

    @GetMapping("/users")
    public String users(Model model){
        List<Empleado> usuarios = this.serviceUser.getUsers();
        model.addAttribute("usuarios", usuarios);
        return "users";
    }

    @GetMapping("/income_expenses")
    public String movements(Model model){
        List<Movimiento> movimientos = this.serviceMovements.getMovements();
        model.addAttribute("movimientos", movimientos);
        return "income_expenses";
    }
}
