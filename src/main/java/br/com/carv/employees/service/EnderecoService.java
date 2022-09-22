package br.com.carv.employees.service;

import br.com.carv.employees.domain.Endereco;
import java.util.List;

public interface EnderecoService {
    
    void salvar(Endereco endereco);

    void atualizar(Endereco endereco);

    void excluirPorId(Long id);

    Endereco buscarPorId(Long id);

    List<Endereco> buscarTodos();
}
