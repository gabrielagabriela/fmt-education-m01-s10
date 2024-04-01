package com.fullstack.fmt.sem10m01.repositories;

import com.fullstack.fmt.sem10m01.entities.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {

    List<AgendaEntity> findByAlunoId(Long alunoId);
    List<AgendaEntity> findByTutorId(Long tutorId);
}
