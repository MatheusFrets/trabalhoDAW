/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matheus
 */
public class TestePersistirRecurso {
    
    
    EntityManagerFactory emf;
    EntityManager em;
    
    
    public TestePersistirRecurso() {
    }
    
    @Before
    public void setUp() {
        
        emf = Persistence.createEntityManagerFactory("TrabalhoDAWPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
    }
    
}
