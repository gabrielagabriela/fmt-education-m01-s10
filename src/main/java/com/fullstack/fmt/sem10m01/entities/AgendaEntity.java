package com.fullstack.fmt.sem10m01.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "agendas")
public class AgendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", referencedColumnName = "id")
    private AlunoEntity aluno;

    @ManyToOne
    @JoinColumn(name = "tutor_id", referencedColumnName = "id")
    private TutorEntity tutor;

    @Column(nullable = false)
    private LocalDateTime data;

    private Boolean status;

    private String tema;

    private String descricao;

}
