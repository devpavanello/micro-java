package br.com.fiap.produtomvc.controllers;

import br.com.fiap.produtomvc.models.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//URL - localhsot:8080/produtos

@Controller //Gerenciado pelo Spring
@RequestMapping("/produtos")//Mapeando URL
public class ProdutoController
{
    //Método ou verbo HTTP
    @GetMapping("/novo")
    public String adicionarProdutos(Model model)
    {
        //As Views ficam dentro da pasta templates
        //Retorna caminho da página cadastro HTML
        model.addAttribute("produto", new Produto());
        return "produto/novo-produto";
    }

    //Recebe dados da View para cadastrar produtos
    @PostMapping("/salvar")
    public String insertProduto(Produto produto)
    {
        System.out.println(produto.toString());
        //Provisório
        return "redirect:/produtos/novo";
    }
}
