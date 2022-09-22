package br.com.carv.employees.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.carv.employees.domain.Funcionario;
import br.com.carv.employees.exception.NotFoundException;
import br.com.carv.employees.repository.FuncionarioRepository;
import br.com.carv.employees.service.FuncionarioService;

@Service
@Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public void salvar(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    @Override
    public void atualizar(Funcionario funcionario) {
        salvar(funcionario);
    }

    @Override
    public void excluirPorId(Long id) {
        funcionarioRepository.delete(buscarPorId(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Funcionario buscarPorId(Long id) {
        return funcionarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Funcionario não encontrado! Id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Funcionario> buscarTodos() {
        return funcionarioRepository.findAll();
    }

    
    
}
