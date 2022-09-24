package br.com.carv.employees.service;

import java.util.List;

import br.com.carv.employees.domain.Cargo;

public interface CargoService {

    void salvar(Cargo cargo);

    void atualizar(Cargo cargo);

    void excluirPorId(Long id);

    Cargo buscarPorId(Long id);

    List<Cargo> buscarTodos();

    boolean cargoTemFuncionarios(Long id);
    
}
