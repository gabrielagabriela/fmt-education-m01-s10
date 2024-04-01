package com.fullstack.fmt.sem10m01.repositories;


import com.fullstack.fmt.sem10m01.entities.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<TutorEntity, Long> {
}
