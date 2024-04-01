package com.fullstack.fmt.sem10m01.service;

import java.util.List;

public interface GenericService<T> {

    T criar(T entity);

    List<T> buscarTodos();

    T buscarPorId(Long id);

    T alterar(Long id, T entity);

    void excluir(Long id);
}
