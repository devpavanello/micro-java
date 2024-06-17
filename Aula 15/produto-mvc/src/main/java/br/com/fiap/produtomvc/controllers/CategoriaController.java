package br.com.fiap.produtomvc.controllers;

import br.com.fiap.produtomvc.models.Categoria;
import br.com.fiap.produtomvc.repository.CategoriaRepository;
import br.com.fiap.produtomvc.services.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    //Injeção de CategoriaService
    @Autowired
    private CategoriaService service;

//    @Autowired
//    private CategoriaRepository repository;

    @GetMapping("/form")
    public String loadFormCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categoria/nova-categoria";
    }

    @PostMapping()
    //@Transactional
    public String insert(@Valid Categoria categoria,
                         BindingResult result,
                         RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "categoria/nova-categoria";
        }
        //repository.save(categoria);
        categoria = service.insert(categoria);
        attributes.addFlashAttribute("mensagem", "Categoria salva com sucesso!");
        return "redirect:/categorias";
    }

    @GetMapping()
    //@Transactional(readOnly = true)
    public String findAll(Model model) {
        List<Categoria> categorias = service.findAll();
        //model.addAttribute("categorias", repository.findAll());
        model.addAttribute("categorias", categorias);
        return "/categoria/listar-categorias";
    }

    @GetMapping("/{id}")
    //@Transactional(readOnly = true)
    public String findById(@PathVariable("id") Long id, Model model) {

//        Categoria categoria = repository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("Recurso inválido - " + id)
//        );
        Categoria categoria = service.findById(id);
        model.addAttribute("categoria", categoria);
        return "/categoria/editar-categoria";
    }

    @PutMapping("{id}")
    public String update(@PathVariable("id") Long id,
                         @Valid Categoria categoria,
                         BindingResult result) {
        if (result.hasErrors()) {
            categoria.setId(id);
            return "/categoria/editar-categoria";
        }
        //repository.save(categoria);
        service.update(id, categoria);
        return "redirect:/categorias";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
//        if (!repository.existsById(id)) {
//            throw new IllegalArgumentException("Recurso inválido - id: " + id);
//        }
//        try {
//            repository.deleteById(id);
//        } catch (DataIntegrityViolationException e) {
//            throw new IllegalArgumentException("Falha de integridade referencial - id: " + id);
//        }
        service.delete(id);
        return "redirect:/categorias";
    }

}










