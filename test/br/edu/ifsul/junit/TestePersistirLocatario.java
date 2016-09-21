/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Locatario;
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


/**
 *
 * @author Matheus
 */
public class TestePersistirLocatario {
     
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirLocatario() {
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
        Boolean exception = false;
        try {
            Locatario obj = new Locatario();
            obj.setNome("Bastiao");
            obj.setEmail("bastiao@gmail.com");
            obj.setCpf("01687588066");
            obj.setTelefone("99377789");    
            obj.setRenda(1000.00);
            obj.setLocalTrabalho("No bar da esquina");      
            obj.setTelefoneTrabalho("33351456");
            
            Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Locatario>> erros = validador.validate(obj);
            
            
            
         
            if (erros.size() > 0) {
                for (ConstraintViolation<Locatario> erro : erros) {
                    System.out.println("Erro: " + erro.getMessage());
                    exception = true;
                }

            } else {
                em.getTransaction().begin();
                em.persist(obj);
                em.getTransaction().commit();
            }
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    
}
}
