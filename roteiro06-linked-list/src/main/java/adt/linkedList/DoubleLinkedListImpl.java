package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.last = new DoubleLinkedListNode<>();
		this.head = new DoubleLinkedListNode<>();
	}

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>();
		newNode.setData(element);
		newNode.setNext(this.head);
		newNode.setPrevious(new DoubleLinkedListNode<>());

		if (this.head.isNIL())
			this.setLast(newNode);
		this.setHead(newNode);
	}

	@Override
	public void insert(T element) {
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>();
		newNode.setData(element);
		newNode.setPrevious(this.getLast());
		newNode.setNext(new DoubleLinkedListNode<>());

		this.getLast().setNext(newNode);

		if (this.isEmpty()) {
			this.setHead(newNode);
		}
		this.setLast(newNode);
	}

	@Override
	public void removeFirst() {
		if (!this.head.isNIL()) {
			this.setHead(this.head.getNext());
			if (this.head.isNIL())
				this.setLast((DoubleLinkedListNode<T>) this.head);
			else
				((DoubleLinkedListNode<T>) this.head).setPrevious(new DoubleLinkedListNode<>());
		}
	}

	@Override
	public void removeLast() {
		if (!this.last.isNIL()) {
			this.setLast(this.last.getPrevious());
			if (this.last.isNIL())
				this.setHead(this.last);
			else
				this.last.setNext(new DoubleLinkedListNode<>());
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
