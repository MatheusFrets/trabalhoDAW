/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.UnidadeCondominial;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matheus
 */
public class TestePersistirPessoa {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirPessoa() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TrabalhoDAWPU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void teste() {
        boolean exception = false;
        try {
            Pessoa p = new Pessoa();
            p.setNome("Manoel");
            p.setEmail("Manoel@gmail.com");
            p.setCpf("92476166626");
            p.setTelefone("99019901");

            Validator validador
                    = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Pessoa>> erros = validador.validate(p);
            if (erros.size() > 0) {
                for (ConstraintViolation<Pessoa> erro : erros) {
                    System.out.println("Erro: " + erro.getMessage());
                }
                exception = true;
            } else {
                em.getTransaction().begin();
                em.persist(p);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
}
