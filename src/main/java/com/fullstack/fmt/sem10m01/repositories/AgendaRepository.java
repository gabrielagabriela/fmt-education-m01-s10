package com.fullstack.fmt.sem10m01.repositories;

import com.fullstack.fmt.sem10m01.entities.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {
}
