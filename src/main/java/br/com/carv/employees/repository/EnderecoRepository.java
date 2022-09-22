package br.com.carv.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carv.employees.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
    
}
