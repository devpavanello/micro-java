package br.com.fiap.produtomvc.controllers;

import br.com.fiap.produtomvc.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorias")
public class CategoriaController
{
    @Autowired
    private CategoriaRepository repository;

    @GetMapping()
    @Transactional(readOnly = true)
    public String findAll(Model model){
        model.addAttribute("categorias", repository.findAll());
        return "/categoria/listar-categorias";
    }
}
