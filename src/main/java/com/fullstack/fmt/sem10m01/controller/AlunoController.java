package com.fullstack.fmt.sem10m01.controller;

import com.fullstack.fmt.sem10m01.entities.AlunoEntity;
import com.fullstack.fmt.sem10m01.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AlunoEntity>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<AlunoEntity> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<AlunoEntity> criar(@RequestBody AlunoEntity aluno){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(aluno));
    }

    @PutMapping("{id}")
    public ResponseEntity<AlunoEntity> alterar(@RequestBody AlunoEntity aluno, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.alterar(id, aluno));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
