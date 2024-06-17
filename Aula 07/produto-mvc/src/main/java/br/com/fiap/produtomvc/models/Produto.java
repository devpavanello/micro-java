package br.com.fiap.produtomvc.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity//Entidade
@Table(name = "tb_produto")//Nome da tabela
public class Produto
{
    //Atributos
    @Id//Definindo a primary-key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Definindo primary-key como identica
    private long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O nome deve ter no minimo 3 caracteres")
    private String nome;

    @NotBlank(message = "Campo requerido")
    @Column(columnDefinition = "TEXT")//Para textos longos
    private String descricao;

    @NotNull(message = "Campo requerido")
    @Positive(message = "O valor deve ser positivo")//Para textos longos
    private double valor;

    //Construtor vazio
    //ALT + INSERT + SELECT NONE
    public Produto()
    {

    }

    //Construtor
    //ALT + INSERT + CTRL A + ENTER
    public Produto(long id, String nome, String descricao, double valor)
    {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    //Getters and Setters
    //ALT + INSERT + GETTERS AND SETTERS + CTRL A + ENTER
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public double getValor()
    {
        return valor;
    }

    public void setValor(double valor)
    {
        this.valor = valor;
    }

    //Equals and HashCode
    //ALT + INSERT + EQUALS AND HASHCODE + ONLY ID
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id == produto.id;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
