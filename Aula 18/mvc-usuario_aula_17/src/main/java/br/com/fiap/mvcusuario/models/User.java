package br.com.fiap.mvcusuario.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres")
    private String nome;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "Campo requerido")
    @Column(unique = true)
    private String email;

    @NotNull(message = "Campo requerido")
    private LocalDate dataNascimento;

    @NotBlank(message = "Campo requerido")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
    private String senha;

}
