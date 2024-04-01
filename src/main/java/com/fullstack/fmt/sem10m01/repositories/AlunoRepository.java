package com.fullstack.fmt.sem10m01.repositories;

import com.fullstack.fmt.sem10m01.entities.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {
}
