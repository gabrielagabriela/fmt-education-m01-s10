package com.fullstack.fmt.sem10m01.service;

import com.fullstack.fmt.sem10m01.entities.AgendaEntity;
import com.fullstack.fmt.sem10m01.exception.NotFoundException;
import com.fullstack.fmt.sem10m01.repositories.AgendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService {


    private final AgendaRepository repository;

    public AgendaServiceImpl(AgendaRepository repository) {
        this.repository = repository;
    }

    @Override
    public AgendaEntity criar(AgendaEntity agenda) {
        agenda.setId(null); // para garantir q terá um id nulo na criação
        return repository.save(agenda);
    }


    @Override
    public List<AgendaEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public AgendaEntity buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Agenda não encontrado com id " +id));
    }

    @Override
    public AgendaEntity alterar(Long id, AgendaEntity entity) {
        buscarPorId(id);
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void excluir(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}
