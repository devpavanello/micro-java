package br.com.fiap.produtomvc.services;

import br.com.fiap.produtomvc.models.Produto;
import br.com.fiap.produtomvc.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService
{
    @Autowired
    private ProdutoRepository repository;

    @Transactional(readOnly = true)
    public List<Produto> findAll(){
        return repository.findAll();
    }

    @Transactional
    public Produto insert(Produto produto){
        return repository.save(produto);
    }

    @Transactional
    public Produto findById(Long id){
        Produto produto = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso inválido - " + id)
        );
        return produto;
    }

    @Transactional
    public Produto update(Long id, Produto entity){
        try{
            Produto produto = repository.getReferenceById(id);
            copyToProduto(entity, produto);
            produto = repository.save(produto);
            return produto;
        }catch (EntityNotFoundException e){
            throw new IllegalArgumentException("Recurso não encotrado");
        }
    }

    private void copyToProduto(Produto entity, Produto produto){
        produto.setNome(entity.getNome());
        produto.setDescricao(entity.getDescricao());
        produto.setValor(entity.getValor());
        produto.setCategoria(entity.getCategoria());
    }

    @Transactional
    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Produto inválido - id: " + id);
        }
        try{
            repository.deleteById(id);
        }catch(Exception e){
            throw new IllegalArgumentException("Produto inválido - id: " + id);
        }
    }
}
