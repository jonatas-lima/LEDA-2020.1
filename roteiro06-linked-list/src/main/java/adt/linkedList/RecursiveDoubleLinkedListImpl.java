package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insertFirst(T element) {
		if (this.isEmpty()) {
			this.setData(element);
			((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
			this.setNext(new RecursiveSingleLinkedListImpl<>());
			this.setPrevious(new RecursiveDoubleLinkedListImpl<>());
		} else {
			RecursiveDoubleLinkedListImpl<T> auxNode = new RecursiveDoubleLinkedListImpl<>();
			auxNode.setData(this.data);
			auxNode.setNext(this.next);
			auxNode.setPrevious(this);

			this.setNext(auxNode);
			this.setData(element);
		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			if (this.next != null) {
				this.setData(this.getNext().data);
				this.setNext(this.getNext().getNext());
			} else {
				this.setData(null);
				this.setNext(new RecursiveSingleLinkedListImpl<>());
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()) {
			this.getLast().setData(null);
		}
	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty()) {
			if (this.data.equals(element)) {
				if (this.previous != null || this.next != null) {
					this.setData(this.getNext().getData());
					this.setNext(this.getNext().getNext());
					if (!this.getNext().isEmpty()) {
						((RecursiveDoubleLinkedListImpl<T>)this.getNext()).setPrevious(this);
					}
				}
			} else {
				this.getNext().remove(element);
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
