package br.com.fab.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fab.model.Disciplina;// Importa a Disciplina do pacote model
import java.util.List;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

    // Método para buscar disciplinas por um professor específico
    // Isso será usado para o painel do professor
    List<Disciplina> findByProfessorId(Long professorId);
}