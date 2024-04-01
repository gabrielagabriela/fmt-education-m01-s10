package com.fullstack.fmt.sem10m01.controller;

import com.fullstack.fmt.sem10m01.entities.AgendaEntity;
import com.fullstack.fmt.sem10m01.service.AgendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("agendas")
public class AgendaController {

    private final AgendaService service;

    public AgendaController(AgendaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AgendaEntity>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<AgendaEntity> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @GetMapping("aluno-id/{alunoId}")
    public ResponseEntity<List<AgendaEntity>> agendamentosAluno(@PathVariable Long alunoId){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorAlunoId(alunoId));
    }

    @GetMapping("aluno-id/{alunoId}/futuros")
    public ResponseEntity<List<AgendaEntity>> agendamentosAlunoFuturos(@PathVariable Long alunoId){
        return ResponseEntity.status(HttpStatus.OK).body(service.bscarProximosPorAlunoId(alunoId));
    }


    @GetMapping("tutor-id/{tutorId}")
    public ResponseEntity<List<AgendaEntity>> agendamentosTutor(@PathVariable Long tutorId){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorTutorId(tutorId));
    }

    @GetMapping("tutor-id/{tutorId}/futuros")
    public ResponseEntity<List<AgendaEntity>> agendamentosTutorFuturos(@PathVariable Long tutorId){
        return ResponseEntity.status(HttpStatus.OK).body(service.bscarProximosPorTutorId(tutorId));
    }


    @PostMapping
    public ResponseEntity<AgendaEntity> criar(@RequestBody AgendaEntity agenda){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(agenda));
    }

    @PutMapping("{id}")
    public ResponseEntity<AgendaEntity> alterar(@RequestBody AgendaEntity agenda, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.alterar(id, agenda));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
