/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Matheus
 * @email omatheusfreitas@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */@Entity
 @Table(name = "mensalidades")
public class Mensalidades implements Serializable{
     @Id
    @SequenceGenerator(name = "seq_mensalidades", sequenceName = "seq_mensalidades_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_mensalidades", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O valor nao pode ser nulo")
    @Column(name = "valor", columnDefinition = "numeric(12,2)")
    private Double valor;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data do vencimento deve ser informada")
    @Column(name = "vencimento", nullable = false)        
    private Calendar vencimento;
    @NotNull(message = "O valor do pagamento nao pode ser nulo")
    @Column(name = "valorPagamento", columnDefinition = "numeric(12,2)")
    private Double valorPagamento;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data do vencimento deve ser informada")
    @Column(name = "dataPagamento") 
    private Calendar dataPagamento;
    @NotNull(message = "O aluguel não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "aluguel", referencedColumnName = "id")
    private Aluguel aluguel;
  

    public Mensalidades() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Calendar getVencimento() {
        return vencimento;
    }

    public void setVencimento(Calendar vencimento) {
        this.vencimento = vencimento;
    }

    public Double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(Double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public Calendar getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Calendar dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Mensalidades other = (Mensalidades) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    

}
