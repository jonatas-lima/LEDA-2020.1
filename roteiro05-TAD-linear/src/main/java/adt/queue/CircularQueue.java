package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (this.isFull())
			throw new QueueOverflowException();

		if (element != null) {
			if (this.isEmpty()) {
				this.head = 0;
				this.tail = 0;
			} else {
				this.tail = (this.tail + 1) % this.array.length;
			}

			this.array[tail] = element;
			this.elements++;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (this.isEmpty())
			throw new QueueUnderflowException();

		T obj = this.array[head];
		this.elements--;

		if (this.head == this.tail) {
			this.head = -1;
			this.tail = -1;
		} else {
			this.head = ((this.head + 1) % this.array.length);
		}

		return obj;
	}

	@Override
	public T head() {
		if (this.isEmpty())
			return null;

		return this.array[head];
	}

	@Override
	public boolean isEmpty() {
		return this.elements == 0 || (this.head == -1 && this.tail == -1);
	}

	@Override
	public boolean isFull() {
		return ((this.tail + 1) % this.array.length) == this.head;
	}

}
