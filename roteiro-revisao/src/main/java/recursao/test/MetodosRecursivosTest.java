package recursao.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import recursao.MetodosRecursivos;

public class MetodosRecursivosTest {

	private MetodosRecursivos metodos;
	
	@Before
	public void setUp() {
		this.metodos = new MetodosRecursivos();
	}
	
	@Test
	public void testFatorialRecursivo() {
		assertEquals(120, metodos.calcularFatorial(5));
		assertEquals(24, metodos.calcularFatorial(4));
		assertEquals(1, metodos.calcularFatorial(0));
		assertEquals(1, metodos.calcularFatorial(1));
	}
	
	@Test
	public void testSomaArrayRecursivo() {
		assertEquals(5, metodos.calcularSomaArray(new int[] {0, 0, 0, 1, 4}));
		assertEquals(0, metodos.calcularSomaArray(new int[] {0, 0, 0, 0, 0}));
		assertEquals(5, metodos.calcularSomaArray(new int[] {1, 1, 1, 1, 1}));
	}

	@Test
	public void testFibonacciRecursivo() {
		assertEquals(1, metodos.calcularFibonacci(1));
		assertEquals(1, metodos.calcularFibonacci(2));
		assertEquals(2, metodos.calcularFibonacci(3));
		assertEquals(5, metodos.calcularFibonacci(5));
		assertEquals(8, metodos.calcularFibonacci(6));
	}
	
	@Test
	public void testCountNotNullRecursivo() {
		assertEquals(4, metodos.countNotNull(new Object[] {"", "", "", ""}));
		assertEquals(3, metodos.countNotNull(new Object[] {"", "", "", null}));
		assertEquals(0, metodos.countNotNull(new Object[] {null, null, null, null}));
	}
	
	@Test
	public void testPotenciaDe2Recursivo() {
		assertEquals(1, metodos.potenciaDe2(0));
		assertEquals(2, metodos.potenciaDe2(1));
		assertEquals(4, metodos.potenciaDe2(2));
		assertEquals(32, metodos.potenciaDe2(5));
	}
	
	@Test
	public void testProgressaoAritmeticaRecursiva() {
		assertEquals(2, metodos.progressaoAritmetica(2, 0, 5), 0.1);
		assertEquals(2, metodos.progressaoAritmetica(2, 0, 10), 0.1);
		assertEquals(6, metodos.progressaoAritmetica(2, 1, 5), 0.1);
	}
	
	@Test
	public void testProgressaoGeometricaRecursiva() {
		assertEquals(1, metodos.progressaoGeometrica(1, 2, 1), 0.1);
		assertEquals(16, metodos.progressaoGeometrica(1, 2, 5), 0.1);
	}
}
