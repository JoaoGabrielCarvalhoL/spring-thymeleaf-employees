package br.com.carv.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carv.employees.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
}
