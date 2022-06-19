/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model.dao;

import model.bean.Livros;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author esrae
 */
public class LivroDAOTest {
    LivroDAO dao = new LivroDAO();
    Livros livro = new Livros();
    public LivroDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dao = new LivroDAO();
        livro = new Livros();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCreate() {
    }

    @Test
    public void testRead() {
    }

    @Test
    public void testReadIndisponivel() {
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testDelete() {
    }

    @Test
    public void testBuscaLivros() {
    }

    @Test
    public void testAlteraInformacoesEmprestimo() {
    }

    @Test
    public void testFazEmprestimo() {
    }

    @Test
    public void testFazDevolucao() {
    }

    @Test
    public void testBuscaLivrosID() {
        
    }
    
}
