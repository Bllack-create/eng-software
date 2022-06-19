/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import model.bean.Livros;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author esrae
 */
public class TelaCarrinhoTest {
    
    public TelaCarrinhoTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testAdd() {
        List<Livros> lista = new ArrayList<Livros>();
        Livros livro = new Livros();
        livro.setNome("Teste");
        livro.setAutor("Teste");
        livro.setId(0);
        lista.add(livro);
        TelaCarrinho tela = new TelaCarrinho(lista);
        assertEquals(1, tela.cesta.size());
    }

    
    
}
