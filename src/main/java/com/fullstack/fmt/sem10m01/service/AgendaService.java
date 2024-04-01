package com.fullstack.fmt.sem10m01.service;

import com.fullstack.fmt.sem10m01.entities.AgendaEntity;

import java.util.List;


public interface AgendaService extends GenericService<AgendaEntity> {
    List<AgendaEntity> buscarPorAlunoId(Long id);

    List<AgendaEntity> buscarPorTutorId(Long id);
}
