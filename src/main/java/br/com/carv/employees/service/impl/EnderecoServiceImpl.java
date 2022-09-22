package br.com.carv.employees.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.carv.employees.domain.Endereco;
import br.com.carv.employees.exception.NotFoundException;
import br.com.carv.employees.repository.EnderecoRepository;
import br.com.carv.employees.service.EnderecoService;

@Service 
@Transactional(readOnly = false)
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public void salvar(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    @Override
    public void atualizar(Endereco endereco) {
        salvar(endereco);
    }

    @Override
    public void excluirPorId(Long id) {
        enderecoRepository.delete(buscarPorId(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Endereco buscarPorId(Long id) {
        return enderecoRepository.findById(id).orElseThrow(() -> new NotFoundException("Endereco não encontrado! Id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Endereco> buscarTodos() {
        return enderecoRepository.findAll();
    }
    
}
