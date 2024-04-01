package com.fullstack.fmt.sem10m01.repositories;


import com.fullstack.fmt.sem10m01.entities.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {
}
