/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Condominio;
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
public class TestePersistirUnidadeCondominial {
    EntityManagerFactory emf;
    EntityManager em;
    public TestePersistirUnidadeCondominial() {
        
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
    public void teste(){
        boolean exception = false;
        try {
            UnidadeCondominial uc = new UnidadeCondominial();
            uc.setDescricao("apartamento 3 quartos");
            uc.setNumero("200");
            uc.setArea(300.00);
            uc.setNumeroQuarto(3);
            uc.setPessoa(em.find(Pessoa.class, 1));
            //falta colocar o condominio akie
            uc.setCondominio(em.find(Condominio.class, 1));
           
            Validator validador
                    = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<UnidadeCondominial>> erros = validador.validate(uc);
            if (erros.size() > 0) {
                for (ConstraintViolation<UnidadeCondominial> erro : erros) {
                    System.out.println("Erro: " + erro.getMessage());
                }
                exception = true;
            } else {
                em.getTransaction().begin();
                em.persist(uc);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
