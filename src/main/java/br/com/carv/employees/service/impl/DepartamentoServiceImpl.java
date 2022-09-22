package br.com.carv.employees.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.carv.employees.domain.Departamento;
import br.com.carv.employees.exception.NotFoundException;
import br.com.carv.employees.repository.DepartamentoRepository;
import br.com.carv.employees.service.DepartamentoService;

@Service
@Transactional(readOnly = false)
public class DepartamentoServiceImpl implements DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    @Autowired
    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public void salvar(Departamento departamento) {
        departamentoRepository.save(departamento);
    }

    @Override
    public void atualizar(Departamento departamento) {
        salvar(departamento);
    }

    @Override
    public void excluirPorId(Long id) {
        departamentoRepository.delete(buscarPorId(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Departamento buscarPorId(Long id) {
        return departamentoRepository.findById(id).orElseThrow(() -> new NotFoundException("Departamento não encontrado! Id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Departamento> buscarTodos() {
        return departamentoRepository.findAll();
    }
    
}
