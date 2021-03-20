package com.validador.cpf.validadorCpf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.validador.cpf.validadorCpf.models.Cliente;
import org.springframework.ui.Model;


@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "home/index";
    }

    @GetMapping("/valida-cpf")
    public String validaCpf(Cliente cliente, Model model){
        boolean verdade = cliente.validarCPF();
        model.addAttribute("verdade", verdade);
        return "home/validaCpf";
    }

}

