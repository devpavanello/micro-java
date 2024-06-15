package br.com.fiap.produtomvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//URL - localhsot:8080/produtos

@Controller //Gerenciado pelo Spring
@RequestMapping("/produtos")//Mapeando URL
public class ProdutoController
{
    //Método ou verbo HTTP
    @GetMapping
    public String adicionarProdutos()
    {
        //As Views ficam dentro da pasta templates
        //Retorna caminho da página cadastro HTML
        return "produto/novo-produto";
    }

    //Recebe dados da View para cadastrar produtos
    @PostMapping()
    public String insertProduto()
    {
        //Provisório
        return "redirect:/produtos";
    }
}
