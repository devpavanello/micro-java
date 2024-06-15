package br.com.fiap.alunomvc.repositories;

import br.com.fiap.alunomvc.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>
{

}
