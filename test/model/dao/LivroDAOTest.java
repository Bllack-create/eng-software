/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import model.bean.Livros;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import junit.runner.BaseTestRunner;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 
 */
public class LivroDAOTest {

    public LivroDAOTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of create method, of class LivroDAO.
     */
    @Test
    public void testCreate() {
        /*Connection conexao = ConnectionFactory.conector();
        PreparedStatement stmt = null;

        Livros livro = new Livros();
        LivroDAO dao = new LivroDAO();
        
        livro.setNome("junit");
        livro.setAssunto("junit");
        livro.setAutor("junit");
        livro.setStatus(true);
        
        if(dao.create(livro).){
        
        }*/

    }

    /**
     * Test of read method, of class LivroDAO.
     */
    @Test
    public void testRead() {
        LivroDAO dao = new LivroDAO();
        
        /*if(dao.read().size()!= 0){
            System.out.println("certo");
        }else{
            System.out.println("errado");
        } Deu errado*/
        /*for(Livros livro: dao.read()){
            System.out.println("Nome:"+ livro.getNome());
        } Deu errado*/
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of readIndisponivel method, of class LivroDAO.
     */
    @Test
    public void testReadIndisponivel() {
        System.out.println("readIndisponivel");
        LivroDAO instance = new LivroDAO();
        List<Livros> expResult = null;
        List<Livros> result = instance.readIndisponivel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class LivroDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Livros livro = null;
        LivroDAO instance = new LivroDAO();
        instance.update(livro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class LivroDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Livros livro = null;
        LivroDAO instance = new LivroDAO();
        instance.delete(livro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscaLivros method, of class LivroDAO.
     */
    @Test
    public void testBuscaLivros() {
        System.out.println("buscaLivros");
        String strBusca = "";
        LivroDAO instance = new LivroDAO();
        List<Livros> expResult = null;
        List<Livros> result = instance.buscaLivros(strBusca);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alteraInformacoesEmprestimo method, of class LivroDAO.
     */
    @Test
    public void testAlteraInformacoesEmprestimo() {
        System.out.println("alteraInformacoesEmprestimo");
        Livros livro = null;
        LivroDAO instance = new LivroDAO();
        instance.alteraInformacoesEmprestimo(livro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fazEmprestimo method, of class LivroDAO.
     */
    @Test
    public void testFazEmprestimo() {
        System.out.println("fazEmprestimo");
        List<Livros> cesta = null;
        LivroDAO instance = new LivroDAO();
        instance.fazEmprestimo(cesta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fazDevolucao method, of class LivroDAO.
     */
    @Test
    public void testFazDevolucao() {
        System.out.println("fazDevolucao");
        List<Livros> cesta = null;
        LivroDAO instance = new LivroDAO();
        instance.fazDevolucao(cesta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscaLivrosID method, of class LivroDAO.
     */
    @Test
    public void testBuscaLivrosID() {
        System.out.println("buscaLivrosID");
        int id = 0;
        LivroDAO instance = new LivroDAO();
        Livros expResult = null;
        Livros result = instance.buscaLivrosID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
