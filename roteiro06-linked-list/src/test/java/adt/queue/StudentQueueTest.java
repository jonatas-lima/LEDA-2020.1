package adt.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;
	public Queue<Integer> queue4;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		queue1 = new QueueDoubleLinkedListImpl<>(4);
		queue2 = new QueueDoubleLinkedListImpl<>(2);
		queue3 = new QueueDoubleLinkedListImpl<>(5);
		queue4 = new QueueDoubleLinkedListImpl<>(0);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(new Integer(1), queue1.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(queue1.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue2.enqueue(new Integer(5)); // vai depender do tamanho que a fila
		// foi iniciada!!!
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), queue3.dequeue()); // vai depender do
		// tamanho que a fial
		// foi iniciada!!!
	}

	@Test
	public void testIsFullTrue() {
		assertTrue(queue2.isFull()); //Para stack2 com tamanho 2
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueStackTamanho0() throws QueueOverflowException{
		queue4.enqueue(2);
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueStackTamanho0() throws QueueUnderflowException{
		queue4.dequeue();
	}

	@Test
	public void testFilaTamanhoNegativo(){
		Queue<Integer> q = new QueueDoubleLinkedListImpl<>(-2);
		assertTrue(q.isEmpty());
		assertNull(q.head());
	}

	@Test
	public void testHeadNull(){
		assertNull(queue3.head());
	}

	@Test
	public void testEnqueueNull() {
		try {
			queue1.enqueue(null);
		} catch (QueueOverflowException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testIsEmptyTrue() {
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testNaoVazia(){
		try {
			queue3.enqueue(new Integer(2));
		} catch (QueueOverflowException e) {
			e.printStackTrace();
		}
		assertFalse(queue3.isEmpty());
	}

	@Test
	public void testEsvaziaFila(){
		try {
			assertEquals(new Integer(1), queue1.dequeue());
			assertEquals(new Integer(2), queue1.dequeue());
			assertEquals(new Integer(3), queue1.dequeue());
		}catch (QueueUnderflowException e){
			e.printStackTrace();
		}
		assertTrue(queue1.isEmpty());
	}

	@Test
	public void testEncheFila(){
		try {
			queue3.enqueue(10);
			queue3.enqueue(8);
			queue3.enqueue(5);
			queue3.enqueue(7);
			queue3.enqueue(9);
			assertEquals(new Integer(10),queue3.head());
		}catch (QueueOverflowException e){
			e.printStackTrace();
		}
		assertTrue(queue3.isFull());
	}

	@Test
	public void testEnqDeqSequencial(){
		try {
			System.out.println(queue1.toString());
			queue1.enqueue(4);
			assertTrue(queue1.isFull());
			assertEquals(new Integer(1), queue1.dequeue());
			System.out.println(queue1.toString());
			assertFalse(queue1.isFull());
			queue1.enqueue(6);
			assertTrue(queue1.isFull());
			assertEquals(new Integer(2), queue1.head());

		}catch (QueueOverflowException | QueueUnderflowException e){
			e.printStackTrace();
		}
	}
}