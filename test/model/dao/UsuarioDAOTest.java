/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model.dao;

import model.bean.Usuarios;
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
public class UsuarioDAOTest {
    public UsuarioDAO dao = new UsuarioDAO();
    public Usuarios user = new Usuarios();
    
    public UsuarioDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dao = new UsuarioDAO();
        user = new Usuarios();
    }
    
    @After
    public void tearDown() {
    }
    /*
    @Test
    public void testCreate() {
    }
    */
    @Test
    public void testBuscaUsuarioPorEmail() {
        user = dao.buscaUsuarioPorEmail("");
        // verifica se não veio um objeto usuario
        assertNotNull(user);
        //fail("O método de buscar usuário por email retorna um objeto null");
        
        assertEquals("tem cadastre de usuario de email com nome null no banco", "null", user.getEmail());
    }
    /*
    @Test
    public void testBuscaUsuarioPorEmaileCPF() {
    }

    @Test
    public void testUpdateSenha() {
    }

    @Test
    public void testUpdateSenhaSemInformar() {
    }

    @Test
    public void testBuscaTodosUsuarios() {
    }
    */
}
