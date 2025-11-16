package br.com.fab.gestao.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import br.com.fab.gestao.model.Usuario; // <--- ADICIONADO!

// ... restante da classe
@Entity
@Table(name = "disciplinas")
@Data // Anotação do Lombok para gerar getters/setters/construtores
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String codigo; // Ex: MAT101, FIS202

    // Relacionamento com o Professor (Um professor gerencia várias disciplinas)
    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Usuario professor; // Deve ser um Usuario com Perfil.PROFESSOR

    // Relacionamento com as Justificativas
    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Justificativa> justificativas;

    // Relacionamento com os Avisos
    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aviso> avisos;

    // Campo de horário/dia da semana (para o requisito de 'disciplinas da semana')
    private String diaDaSemana; // Ex: SEGUNDA, TERCA

    private String horario; // Ex: 08:00 - 10:00
}