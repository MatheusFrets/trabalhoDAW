/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Locatario;
import br.edu.ifsul.modelo.Recurso;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matheus
 */
public class TestePersistirRecursosCondominios {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirRecursosCondominios() {
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
        Boolean exception = false;
        try {
            Recurso r = new Recurso();
            r.setDescricao("Problema na agua da calha");
            

            Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Recurso>> erros = validador.validate(r);

            if (erros.size() > 0) {
                for (ConstraintViolation<Recurso> erro : erros) {
                    System.out.println("Erro: " + erro.getMessage());
                    exception = true;
                }

            } else {
                em.getTransaction().begin();
                em.persist(r);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);

    }

}
