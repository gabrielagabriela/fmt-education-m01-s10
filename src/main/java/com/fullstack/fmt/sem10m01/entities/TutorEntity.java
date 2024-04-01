package com.fullstack.fmt.sem10m01.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tutores")
public class TutorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String especialidade;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    private List<AgendaEntity> agenda;

}
