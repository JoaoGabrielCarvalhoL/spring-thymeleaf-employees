package br.com.carv.employees.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Departamento extends AbstractEntity {
    
    @Column(nullable = false, length = 100, unique = true)
    private String nome; 

    @OneToMany(mappedBy = "departamento", fetch = FetchType.EAGER)
    private List<Cargo> cargos;
 
    public Departamento() {

    }

    public Departamento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }
}
