/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Matheus
 * @email omatheusfreitas@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
@Entity
@Table(name = "locatario")
public class Locatario extends Pessoa implements Serializable {

    @NotNull(message = "A renda nao pode ser nula")
    @Column(name = "renda")
    private Double Renda;

    @NotBlank(message = "Informe o local de trabson.")
    @Column(name = "localTrabalho", length = 50, nullable = false)
    private String localTrabalho;

    @NotBlank(message = "Informe o telefone.")
    @Column(name = "telefoneTrabalho", length = 25, nullable = false)
    private String telefoneTrabalho;

    public Locatario() {
    }

    public Double getRenda() {
        return Renda;
    }

    public void setRenda(Double Renda) {
        this.Renda = Renda;
    }

    public String getLocalTrabalho() {
        return localTrabalho;
    }

    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    public String getTelefoneTrabalho() {
        return telefoneTrabalho;
    }

    public void setTelefoneTrabalho(String telefoneTrabalho) {
        this.telefoneTrabalho = telefoneTrabalho;
    }

}
