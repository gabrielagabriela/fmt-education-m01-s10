package com.fullstack.fmt.sem10m01.controller;

import com.fullstack.fmt.sem10m01.entities.TutorEntity;
import com.fullstack.fmt.sem10m01.service.TutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tutores")
public class TutorController {

    private final TutorService service;

    public TutorController(TutorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TutorEntity>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<TutorEntity> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<TutorEntity> criar(@RequestBody TutorEntity tutor){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(tutor));
    }

    @PutMapping("{id}")
    public ResponseEntity<TutorEntity> alterar(@RequestBody TutorEntity tutor, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.alterar(id, tutor));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
