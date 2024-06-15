package br.com.fiap.alunomvc.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity//Entidade
@Table(name = "")//Nome da tabbela
public class Aluno
{
    //Atributos
    @Id//Definindo a primary-key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Definindo primary-key como identica
    private long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O nome deve conter no minimo 3 caracteres")
    private String nome;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O campo deve conter no minimo 3 caracteres")
    private String email;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O campo deve conter no minimo 3 caracteres")
    private String rm;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O campo deve conter no minimo 3 caracteres")
    private String turma;

    //Construtor vazio
    public Aluno()
    {

    }

    //Construtor
    public Aluno(long id, String nome, String email, String rm, String turma)
    {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.rm = rm;
        this.turma = turma;
    }

    //Getters and Setters
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getRm()
    {
        return rm;
    }

    public void setRm(String rm)
    {
        this.rm = rm;
    }

    public String getTurma()
    {
        return turma;
    }

    public void setTurma(String turma)
    {
        this.turma = turma;
    }

    //Equals and Hashcode
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return id == aluno.id;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }

    //To String
    @Override
    public String toString()
    {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", rm='" + rm + '\'' +
                ", turma='" + turma + '\'' +
                '}';
    }
}
