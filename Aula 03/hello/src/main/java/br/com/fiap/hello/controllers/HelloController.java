package br.com.fiap.hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller//Define que essa classe é gerenciada pelo Spring
@RequestMapping("/hello")//Mapeando a URL da aplicação
public class HelloController 
{
	@GetMapping()
	public String mostrarMensagem(@RequestParam(name="nome",
												required=false,
												defaultValue="FIAP")
											String nome, Model model){
		
		/*
		 *
		 */
		model.addAttribute("nome", nome);
		
		/*
		 * ação desejada
		 * devolve o caminho para View
		 * e a página HTML que será exibida
		 */
		return "view/hello";
	}
}
