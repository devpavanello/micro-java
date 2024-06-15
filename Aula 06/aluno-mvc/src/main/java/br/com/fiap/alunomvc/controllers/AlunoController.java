package br.com.fiap.alunomvc.controllers;

import br.com.fiap.alunomvc.models.Aluno;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Url - localhost:8080/aluno

@Controller
@RequestMapping("/aluno")//Mapeando URL
public class AlunoController
{
    //Método ou verbo HTTP
    @GetMapping("/novo")
    public String adicionarAluno(Model model)
    {
        model.addAttribute("aluno", new Aluno());
        return "aluno/novo";
    }

    @PostMapping("/salvar")
    public String insertAlunos(Aluno aluno)
    {
        System.out.println(aluno.toString());
        //Provisorio
        return "redirect:/aluno/novo";
    }
}
