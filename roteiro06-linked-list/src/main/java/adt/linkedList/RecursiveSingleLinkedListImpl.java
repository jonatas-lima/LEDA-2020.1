package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {
		if (this.isEmpty())
			return 0;
		return 1 + this.next.size();
	}

	@Override
	public T search(T element) {
		if (this.isEmpty()) {
			return null;
		}
		if (this.data.equals(element)) {
			return this.data;
		}

		return this.getNext().search(element);
	}

	@Override
	public void insert(T element) {
		if (this.isEmpty()) {
			this.setData(element);
			this.setNext(new RecursiveSingleLinkedListImpl<>());
		} else {
			this.getNext().insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (this.data.equals(element)) {
			this.setData(this.getNext().getData());
			this.setNext(this.getNext().getNext());
		} else if (!this.isEmpty()) {
			this.getNext().remove(element);
		}
	}

	@Override
	public T[] toArray() {
		if (this.isEmpty()) {
			return (T[]) new Comparable[0];
		}
		T[] result = (T[]) new Comparable[this.size()];
		toArray(result, this, 0);
		return result;
	}

	private void toArray(T[] array, RecursiveSingleLinkedListImpl<T> node, int i) {
		if (!node.isEmpty()) {
			array[i] = node.getData();
			this.toArray(array, node.getNext(), i + 1);
		}
	}

	protected RecursiveSingleLinkedListImpl<T> getLast() {
		if (this.getNext().isEmpty())
			return this;

		return this.getNext().getLast();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
