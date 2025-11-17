package br.com.fab.gestao.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Table(name = "disciplinas")
@Data
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String codigo; // Ex: MAT101, FIS202

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Usuario professor; // Deve ser um Usuario com Perfil.PROFESSOR

    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Justificativa> justificativas;

    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aviso> avisos;

    private String diaDaSemana;
    // Ex: 08:00 - 10:00
}