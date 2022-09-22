package br.com.carv.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carv.employees.domain.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    
}
