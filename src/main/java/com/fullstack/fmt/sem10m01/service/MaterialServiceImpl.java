package com.fullstack.fmt.sem10m01.service;

import com.fullstack.fmt.sem10m01.entities.MaterialEntity;
import com.fullstack.fmt.sem10m01.exception.NotFoundException;
import com.fullstack.fmt.sem10m01.repositories.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {


    private final MaterialRepository repository;

    public MaterialServiceImpl(MaterialRepository repository) {
        this.repository = repository;
    }

    @Override
    public MaterialEntity criar(MaterialEntity material) {
        material.setId(null); // para garantir q terá um id nulo na criação
        return repository.save(material);
    }


    @Override
    public List<MaterialEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public MaterialEntity buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Material não encontrado com id " +id));
    }

    @Override
    public MaterialEntity alterar(Long id, MaterialEntity entity) {
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
