package br.com.carv.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carv.employees.domain.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
    
}
