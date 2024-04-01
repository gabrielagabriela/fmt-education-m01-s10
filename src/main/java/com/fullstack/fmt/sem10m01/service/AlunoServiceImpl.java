package com.fullstack.fmt.sem10m01.service;

import com.fullstack.fmt.sem10m01.entities.AlunoEntity;
import com.fullstack.fmt.sem10m01.exception.NotFoundException;
import com.fullstack.fmt.sem10m01.repositories.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {


    private final AlunoRepository repository;

    public AlunoServiceImpl(AlunoRepository repository) {
        this.repository = repository;
    }

    @Override
    public AlunoEntity criar(AlunoEntity aluno) {
        aluno.setId(null); // para garantir q terá um id nulo na criação
        return repository.save(aluno);
    }


    @Override
    public List<AlunoEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public AlunoEntity buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Aluno não encontrado com id " +id));
    }

    @Override
    public AlunoEntity alterar(Long id, AlunoEntity entity) {
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
