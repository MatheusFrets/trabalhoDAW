/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;


import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Locatario;
import br.edu.ifsul.modelo.Mensalidades;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class TestePersistirMensalidades {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirMensalidades() {
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

    /**
     *
     */
    @Test
    public void teste() {
        boolean exception = false;
        try {
            Mensalidades m = new Mensalidades();
            Aluguel al = em.find(Aluguel.class, 1);
            
            m.setValor(500.00);
            m.setVencimento(new GregorianCalendar(2015,11,30));
            m.setDataPagamento(new GregorianCalendar(2015,10,30));
            m.setValorPagamento(500.00);
            
           
            al.adicionarMensalidades(m);
            Validator validador
                    = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Mensalidades>> erros = validador.validate(m);
            if (erros.size() > 0) {
                for (ConstraintViolation<Mensalidades> erro : erros) {
                    System.out.println("Erro: " + erro.getMessage());
                }
                exception = true;
            } else {
                em.getTransaction().begin();
                em.persist(m);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }

}
