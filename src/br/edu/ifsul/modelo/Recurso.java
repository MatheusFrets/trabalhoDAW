/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Matheus
 * @email omatheusfreitas@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */@Entity
 @Table(name = "recurso")
public class Recurso {
     @Id
    @SequenceGenerator(name = "seq_recurso", sequenceName = "seq_recurso_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_recurso", strategy = GenerationType.SEQUENCE)
    private Integer id;
     @NotNull(message = "A descricao nao pode ser em branco")
     @Column(name = "descricao")
    private String descricao;
     @ManyToMany
    @JoinTable(name = "recursos", 
            joinColumns = 
                @JoinColumn(name = "recurso", referencedColumnName = "id", 
                    nullable = false),
            inverseJoinColumns = // guarda a coluna da classe da lista List<Produto>
                @JoinColumn(name = "recurso", referencedColumnName = "id", 
                    nullable = false))
    private List<Condominio> condominios = new ArrayList<>();
     
//colocar o many to many algo assim
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recurso other = (Recurso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
     
     

}
