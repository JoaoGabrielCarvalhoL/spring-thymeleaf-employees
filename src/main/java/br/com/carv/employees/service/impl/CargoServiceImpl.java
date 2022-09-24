package br.com.carv.employees.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.carv.employees.domain.Cargo;
import br.com.carv.employees.exception.NotFoundException;
import br.com.carv.employees.repository.CargoRepository;
import br.com.carv.employees.service.CargoService;

@Service
@Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService {


    private final CargoRepository cargoRepository;

    @Autowired
    public CargoServiceImpl(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Override
    public void salvar(Cargo cargo) {
        cargoRepository.save(cargo);
    }

    @Override
    public void atualizar(Cargo cargo) {
        salvar(cargo);
    }

    @Override
    public void excluirPorId(Long id) {
        cargoRepository.delete(buscarPorId(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Cargo buscarPorId(Long id) {
        return cargoRepository.findById(id).orElseThrow(() -> new NotFoundException("Cargo não encontrado! Id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cargo> buscarTodos() {
        return cargoRepository.findAll();
    }

    @Override
    public boolean cargoTemFuncionarios(Long id) {
        if (buscarPorId(id).getFuncionarios().isEmpty()) {
            return false;
        }
        return true;
    }
    
}
