package br.com.carv.employees.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Endereco extends AbstractEntity {
    
    @NotBlank(message = "O nome do logradouro é obrigatório.")
    @Size(max = 80, message = "O logradouro do logradouro deve conter no máximo {max} caracteres.")
    @Column(nullable = false)
    private String logradouro;

    @NotBlank(message = "O nome do bairro é obrigatório.")
    @Size(max = 60, min = 3, message = "O nome do bairro deve ter entre {min} e {max} caracteres.")
    @Column(nullable = false)
    private String bairro; 

    @NotBlank(message = "O nome da cidade é obrigatório.")
    @Size(max = 60, min = 3, message = "O nome do cidade deve ter entre {min} e {max} caracteres.")
    @Column(nullable = false)
    private String cidade;

    @Enumerated(EnumType.STRING)
    private UF uf;

    @NotBlank(message = "O cep é obrigatório.")
    @Column(nullable = false, length = 9)
    private String cep;

    @NotBlank(message = "O número é obrigatório.")
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
