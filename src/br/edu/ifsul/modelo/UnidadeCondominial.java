/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Matheus
 * @email omatheusfreitas@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
@Entity
@Table(name = "unidadeCondominial")
public class UnidadeCondominial implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_unidade", sequenceName = "seq_unidade_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_unidade", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "o numero nao pode ser nulo")
    @Column(name = "numero", length = 10)
    private String numero;
    @NotNull(message = "A descricao nao pode ser nula")
    @Column(name = "descricao", columnDefinition = "text")
    private String descricao;
    @NotNull(message = "A area nao pode ser nula")
    @Column(name = "area")
    private Double area;
    @NotNull(message = "o numero do quarto nao pode ser nulo")
    @Column(name = "numeroquarto", length = 10)
    private Integer numeroQuarto;
    @NotNull(message = "A pessoa não pode ser nula")
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;
    @NotNull(message = "O Condominio não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "condominio", referencedColumnName = "id", nullable = false)
    private Condominio condominio;

    public UnidadeCondominial() {
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final UnidadeCondominial other = (UnidadeCondominial) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }
    
    

}
