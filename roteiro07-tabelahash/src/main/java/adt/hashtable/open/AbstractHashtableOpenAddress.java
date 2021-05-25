package adt.hashtable.open;

import adt.hashtable.AbstractHashtable;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public abstract class AbstractHashtableOpenAddress<T extends Storable> extends
		AbstractHashtable<T> {

	protected final DELETED deletedElement = new DELETED();
	private int tableSize;

	public AbstractHashtableOpenAddress(int size) {
		this.tableSize = size;
		this.initiateInternalTable(size);
	}

	@Override
	protected void initiateInternalTable(int size) {
		this.table = new Storable[size];
	}

	protected int getHash(T element, int probe) {
		try {
			return ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probe);
		} catch (ClassCastException e) {
			return ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probe);
		}
	}
}
