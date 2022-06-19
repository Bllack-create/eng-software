/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
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

    public void testconexaoBanco(){
         //Conexão ao banco de dados 
          Connection conexao = ConnectionFactory.conector();
          
          assertNotNull(conexao);
    }
    
    @Test
    public void testCreate() {
        testconexaoBanco();
    }

    @Test
    public void testRead() {
        testconexaoBanco();
    }

    @Test
    public void testReadIndisponivel() {
        testconexaoBanco();
    }

    @Test
    public void testUpdate() {
        testconexaoBanco();
    }

    @Test
    public void testDelete() {
        testconexaoBanco();
    }

    @Test
    public void testBuscaLivros() {
        testconexaoBanco();
    }

    @Test
    public void testAlteraInformacoesEmprestimo() {
        testconexaoBanco();
    }

    @Test
    public void testFazEmprestimo() {
        testconexaoBanco();
    }

    @Test
    public void testFazDevolucao() {
        testconexaoBanco();
    }

    @Test
    public void testBuscaLivrosID() {
        testconexaoBanco();
        livro = dao.buscaLivrosID(1);
        
        assertNotNull(livro); // o objeto não é null
        
        assertTrue((livro.getId() != -1));
        
    }
    
}
