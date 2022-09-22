package br.com.carv.employees.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Endereco extends AbstractEntity {
    
    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String bairro; 

    @Column(nullable = false)
    private String cidade;

    @Enumerated(EnumType.STRING)
    private UF uf;

    @Column(nullable = false, length = 9)
    private String cep;

    @Column(nullable = false, length = 10)
    private String numero;

    private String complemento;

    public Endereco() {

    }

    public Endereco(String logradouro, String bairro, String cidade, UF uf, String cep, String numero, String complemento) {
        this.logradouro = logradouro; 
        this.bairro = bairro; 
        this.cidade = cidade; 
        this.uf = uf; 
        this.cep = cep; 
        this.numero = numero; 
        this.complemento = complemento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
