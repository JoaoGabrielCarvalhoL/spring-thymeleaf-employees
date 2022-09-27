package br.com.carv.employees.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.carv.employees.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Query(value = "SELECT f FROM Funcionario f WHERE f.nome LIKE %:nome%")
    List<Funcionario> findByNome(String nome);

    @Query(value = "SELECT f FROM Funcionario f WHERE f.cargo.id = id")
    List<Funcionario> findByCargoId(Long id);

    @Query(value = "SELECT f FROM Funcionario f WHERE f.dataAdmissao >= entrada and f.dataDemissao <= saida ORDER BY f.dataAdmissao asc")
    List<Funcionario> findByDataEntradaDataSaida(@Param("entrada") LocalDate entrada, @Param("saida") LocalDate saida);

    @Query(value = "SELECT f FROM Funcionario f WHERE f.dataAdmissao =:entrada ORDER BY f.dataAdmissao asc")
    List<Funcionario> findByDataEntrada(@Param("entrada") LocalDate entrada);

    @Query(value = "SELECT f FROM Funcionario f WHERE f.dataDemissao =:saida ORDER BY f.dataDemissao asc")
    List<Funcionario> findByDataSaida(@Param("saida") LocalDate saida);
}
