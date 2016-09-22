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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Matheus
 * @email omatheusfreitas@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "condominio")
public class Condominio {
    @Id
    @SequenceGenerator(name = "seq_condominio", sequenceName = "seq_condominio_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_condominio", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O nome nao pode ser nulo")
    @NotBlank(message = "O nome nao pode ser em branco")
    @Column(name = "nome", length = 50)
    private String nome;
    @NotNull(message = "O endereco nao pode ser nulo")
    @NotBlank(message = "O endereco nao pode ser em branco")
    @Column(name = "endereco", length = 60)
    private String endereco;
    @NotNull(message = "O numero nao pode ser nulo")
    @NotBlank(message = "O numero nao pode ser em branco")
    @Column(name = "numero", length = 10)
    private String numero;
    @NotNull(message = "O cep nao pode ser nulo")
    @NotBlank(message = "O cep nao pode ser em branco")
    @Column(name = "cep", length = 8)
    private String cep;

    @ManyToMany
    @JoinTable(name = "recursos", 
            joinColumns = 
                @JoinColumn(name = "condominio", referencedColumnName = "id", 
                    nullable = false),
            inverseJoinColumns = // guarda a coluna da classe da lista List<Produto>
                @JoinColumn(name = "recurso", referencedColumnName = "id", 
                    nullable = false))
    private List<Recurso> recursos = new ArrayList<>();
    
    
    public Condominio() {
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

  

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Condominio other = (Condominio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }

    
    
}
