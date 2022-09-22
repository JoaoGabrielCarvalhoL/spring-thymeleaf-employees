package br.com.carv.employees.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Funcionario extends AbstractEntity {

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
    private BigDecimal salario; 

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate dataAdmissao;

    @Column(columnDefinition = "DATE")
    private LocalDate dataDemissao;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @ManyToOne
    private Cargo cargo; 

    public Funcionario() {

    }

    public Funcionario(String nome, BigDecimal salario, LocalDate dataAdmissao, LocalDate dataDemissao) {
        this.nome = nome; 
        this.salario = salario; 
        this.dataAdmissao = dataAdmissao; 
        this.dataDemissao = dataDemissao;
    }

    public String getNome() {
        return nome; 
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public LocalDate getDataDemissao() {
        return dataDemissao;
    }
    
    public void setDataDemissao(LocalDate dataDemissao) {
        this.dataDemissao = dataDemissao;
    }
    
    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
