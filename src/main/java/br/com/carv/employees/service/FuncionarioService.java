package br.com.carv.employees.service;

import br.com.carv.employees.domain.Funcionario;
import java.util.List;

public interface FuncionarioService {
    
    void salvar(Funcionario funcionario);

    void atualizar(Funcionario funcionario);

    void excluirPorId(Long id);

    Funcionario buscarPorId(Long id);

    List<Funcionario> buscarTodos();
}
