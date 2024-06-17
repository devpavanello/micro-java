package br.com.fiap.mvcusuario.dto;

import br.com.fiap.mvcusuario.models.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.time.LocalDate;

public class UserDTO {

    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres")
    private String nome;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "Campo requerido")
    private String email;

    @NotNull(message = "Campo requerido")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    //data do cadastro - sem TIME ZONE
    private Instant moment;

    @NotBlank(message = "Campo requerido")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
    private String senha;

    public UserDTO() {
    }

    public UserDTO(Long id, String nome, String email, LocalDate dataNascimento, Instant moment, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.moment = moment;
        this.senha = senha;
    }

    public UserDTO(User entity) {
        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();
        dataNascimento = entity.getDataNascimento();
        moment = entity.getMoment();
        senha = entity.getSenha();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Instant getMoment() {
        return moment;
    }

    public String getSenha() {
        return senha;
    }
}
