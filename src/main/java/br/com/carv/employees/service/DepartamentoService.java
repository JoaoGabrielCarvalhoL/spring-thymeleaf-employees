package br.com.carv.employees.service;

import br.com.carv.employees.domain.Departamento;
import java.util.List;

public interface DepartamentoService {

    void salvar(Departamento departamento);

    void atualizar(Departamento departamento);

    void excluirPorId(Long id);

    Departamento buscarPorId(Long id);

    List<Departamento> buscarTodos();

    boolean departamentoTemCargos(Long id);
    
}
