package adt.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentStackTest {

	public Stack<Integer> stack1;
	public Stack<Integer> stack2;
	public Stack<Integer> stack3;
	public Stack<Integer> stack4;

	@Before
	public void setUp() throws StackOverflowException {

		getImplementations();

		// Pilha com 3 elementos não cheia.
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);

		// Pilha com 2 elementos de tamanho 2, pilha cheia.
		stack2.push(1);
		stack2.push(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		stack1 = new StackDoubleLinkedListImpl<>(4);
		stack2 = new StackDoubleLinkedListImpl<>(2);
		stack3 = new StackDoubleLinkedListImpl<>(6);
		stack4 = new StackDoubleLinkedListImpl<>(0);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testTop() {
		assertEquals(new Integer(3), stack1.top());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(stack1.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(stack1.isFull()); // vai depender do tamanho que a pilha foi
		// iniciada!!!!
	}

	@Test
	public void testPush() {
		try {
			stack1.push(new Integer(5));
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = StackOverflowException.class)
	public void testPushComErro() throws StackOverflowException {
		stack2.push(new Integer(5)); // levanta excecao apenas se o tamanhonao
		// permitir outra insercao

	}

	@Test
	public void testPop() {
		try {
			assertEquals(new Integer(3), stack1.pop());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = StackUnderflowException.class)
	public void testPopComErro() throws StackUnderflowException {
		assertEquals(new Integer(3), stack3.pop()); // levanta excecao apenas se
		// stack1 for vazia
	}

	@Test
	public void testIsFullTrue() {
		assertTrue(stack2.isFull()); //Para stack2 com tamanho 2
	}

	@Test(expected = StackOverflowException.class)
	public void testPushStackTamanho0() throws StackOverflowException{
		stack4.push(2);
	}

	@Test(expected = StackUnderflowException.class)
	public void testPopStackTamanho0() throws StackUnderflowException{
		stack4.pop();
	}

	@Test
	public void testTopNull(){
		assertNull(stack3.top());
	}

	@Test
	public void testPushNull() {
		try {
			stack1.push(null);
		} catch (StackOverflowException e) {
			e.printStackTrace();
		}
		assertEquals(new Integer(3), stack1.top());
	}

	@Test
	public void testIsEmptyTrue() {
		assertTrue(stack3.isEmpty());
	}

	@Test
	public void testNaoVazia(){
		try {
			stack3.push(new Integer(2));
		} catch (StackOverflowException e) {
			e.printStackTrace();
		}
		assertFalse(stack3.isEmpty());
	}

	@Test
	public void testEsvaziaPilha(){
		try {
			assertEquals(new Integer(3), stack1.pop());
			assertEquals(new Integer(2), stack1.pop());
			assertEquals(new Integer(1), stack1.pop());
		}catch (StackUnderflowException e){
			e.printStackTrace();
		}
		assertTrue(stack1.isEmpty());
	}

	@Test
	public void testEnchePilha(){
		try {
			stack3.push(10);
			stack3.push(8);
			stack3.push(5);
			stack3.push(7);
			stack3.push(9);
			stack3.push(6);
			assertEquals(new Integer(6),stack3.top());
		}catch (StackOverflowException e){
			e.printStackTrace();
		}
		assertTrue(stack3.isFull());
	}
}