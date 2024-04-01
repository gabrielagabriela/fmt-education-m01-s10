package com.fullstack.fmt.sem10m01.service;

import com.fullstack.fmt.sem10m01.entities.TutorEntity;
import com.fullstack.fmt.sem10m01.exception.NotFoundException;
import com.fullstack.fmt.sem10m01.repositories.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorServiceImpl implements TutorService {


    private final TutorRepository repository;

    public TutorServiceImpl(TutorRepository repository) {
        this.repository = repository;
    }

    @Override
    public TutorEntity criar(TutorEntity tutor) {
        tutor.setId(null); // para garantir q terá um id nulo na criação
        return repository.save(tutor);
    }


    @Override
    public List<TutorEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public TutorEntity buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Tutor não encontrado com id " +id));
    }

    @Override
    public TutorEntity alterar(Long id, TutorEntity entity) {
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
