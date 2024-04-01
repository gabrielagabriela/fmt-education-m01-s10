package com.fullstack.fmt.sem10m01.service;

import com.fullstack.fmt.sem10m01.entities.AgendaEntity;
import com.fullstack.fmt.sem10m01.entities.AlunoEntity;
import com.fullstack.fmt.sem10m01.entities.TutorEntity;
import com.fullstack.fmt.sem10m01.exception.NotFoundException;
import com.fullstack.fmt.sem10m01.repositories.AgendaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService {


    private final AgendaRepository repository;
    private final AlunoService alunoService;
    private final TutorService tutorService;
    // para verificar e tratar erros

    public AgendaServiceImpl(AgendaRepository repository, AlunoService alunoService, TutorService tutorService) {
        this.repository = repository;
        this.alunoService = alunoService;
        this.tutorService = tutorService;
    }

    @Override
    public AgendaEntity criar(AgendaEntity agenda) {
        agenda.setId(null); // para garantir q terá um id nulo na criação

        AlunoEntity aluno = alunoService.buscarPorId(agenda.getAluno().getId());
        agenda.setAluno(aluno);

        TutorEntity tutor = tutorService.buscarPorId(agenda.getTutor().getId());
        agenda.setTutor(tutor);

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

    @Override
    public List<AgendaEntity> buscarPorAlunoId(Long alunoId) {
        alunoService.buscarPorId(alunoId);
        return repository.findByAlunoId(alunoId);
    }

    @Override
    public List<AgendaEntity> buscarPorTutorId(Long tutorId) {
        tutorService.buscarPorId(tutorId);
        return repository.findByTutorId(tutorId);
    }

    @Override
    public List<AgendaEntity> bscarProximosPorAlunoId(Long alunoId) {
        alunoService.buscarPorId(alunoId);
        return repository.findByAlunoIdAndDataGreaterThanOrderByData(alunoId, LocalDateTime.now());
    }

    @Override
    public List<AgendaEntity> bscarProximosPorTutorId(Long tutorId) {
        tutorService.buscarPorId(tutorId);
        return repository.findByTutorIdAndDataGreaterThanOrderByData(tutorId, LocalDateTime.now());
    }
}
