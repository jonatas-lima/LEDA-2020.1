package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		if (isEmpty())
			return 0;

		SingleLinkedListNode<T> aux = this.getHead();
		int cont = 0;
		while (!aux.isNIL()) {
			cont++;
			aux = aux.next;
		}
		return cont;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> aux = this.getHead();
		while (!aux.isNIL()) {
			if (aux.data.equals(element))
				return aux.data;
			aux = aux.next;
		}
		return null;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>();
				newNode.setData(element);
				newNode.setNext(this.head);
				this.setHead(newNode);
			} else {
				SingleLinkedListNode<T> aux = this.head;
				while (!aux.isNIL()) {
					aux = aux.next;
				}
				aux.setData(element);
				aux.setNext(new SingleLinkedListNode<>());
			}
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty() && element != null) {
			SingleLinkedListNode<T> aux = this.getHead();
			while (!aux.isNIL()) {
				if (aux.data.equals(element)) {
					aux.setData(aux.next.data);
					aux.setNext(aux.next.next);
					break;
				}
				aux = aux.next;
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] arr = (T[]) new Comparable[this.size()];
		SingleLinkedListNode<T> aux = this.getHead();
		int i = 0;
		while (!aux.isNIL()) {
			arr[i++] = aux.data;
			aux = aux.next;
		}
		return arr;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
