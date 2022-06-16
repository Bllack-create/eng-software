/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package model.dao;

import java.util.List;
import model.bean.Usuarios;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author esrae
 */
public class UsuarioDAOTest {
    
    public UsuarioDAOTest() {
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
     * Test of create method, of class UsuarioDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Usuarios cliente = null;
        UsuarioDAO instance = new UsuarioDAO();
        instance.create(cliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscaUsuarioPorEmail method, of class UsuarioDAO.
     */
    @Test
    public void testBuscaUsuarioPorEmail() {
        System.out.println("buscaUsuarioPorEmail");
        String email = "";
        UsuarioDAO instance = new UsuarioDAO();
        Usuarios expResult = null;
        Usuarios result = instance.buscaUsuarioPorEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscaUsuarioPorEmaileCPF method, of class UsuarioDAO.
     */
    @Test
    public void testBuscaUsuarioPorEmaileCPF() {
        System.out.println("buscaUsuarioPorEmaileCPF");
        String email = "";
        String cpf = "";
        UsuarioDAO instance = new UsuarioDAO();
        Usuarios expResult = null;
        Usuarios result = instance.buscaUsuarioPorEmaileCPF(email, cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSenha method, of class UsuarioDAO.
     */
    @Test
    public void testUpdateSenha() {
        System.out.println("updateSenha");
        Usuarios usuario = null;
        UsuarioDAO instance = new UsuarioDAO();
        instance.updateSenha(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSenhaSemInformar method, of class UsuarioDAO.
     */
    @Test
    public void testUpdateSenhaSemInformar() {
        System.out.println("updateSenhaSemInformar");
        Usuarios usuario = null;
        UsuarioDAO instance = new UsuarioDAO();
        instance.updateSenhaSemInformar(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscaTodosUsuarios method, of class UsuarioDAO.
     */
    @Test
    public void testBuscaTodosUsuarios() {
        System.out.println("buscaTodosUsuarios");
        UsuarioDAO instance = new UsuarioDAO();
        List<Usuarios> expResult = null;
        List<Usuarios> result = instance.buscaTodosUsuarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
