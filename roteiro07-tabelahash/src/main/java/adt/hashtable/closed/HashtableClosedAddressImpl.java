package adt.hashtable.closed;

import adt.hashtable.hashfunction.*;
import adt.hashtable.open.DELETED;
import util.Util;

import java.util.Iterator;
import java.util.LinkedList;

public class HashtableClosedAddressImpl<T> extends
		AbstractHashtableClosedAddress<T> {

	/**
	 * A hash table with closed address works with a hash function with closed
	 * address. Such a function can follow one of these methods: DIVISION or
	 * MULTIPLICATION. In the DIVISION method, it is useful to change the size
	 * of the table to an integer that is prime. This can be achieved by
	 * producing such a prime number that is bigger and close to the desired
	 * size.
	 * 
	 * For doing that, you have auxiliary methods: Util.isPrime and
	 * getPrimeAbove as documented bellow.
	 * 
	 * The length of the internal table must be the immediate prime number
	 * greater than the given size (or the given size, if it is already prime). 
	 * For example, if size=10 then the length must
	 * be 11. If size=20, the length must be 23. You must implement this idea in
	 * the auxiliary method getPrimeAbove(int size) and use it.
	 * 
	 * @param desiredSize
	 * @param method
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HashtableClosedAddressImpl(int desiredSize,
			HashFunctionClosedAddressMethod method) {
		int realSize = desiredSize;

		if (method == HashFunctionClosedAddressMethod.DIVISION) {
			realSize = this.getPrimeAbove(desiredSize); // real size must the
														// the immediate prime
														// above
		}
		initiateInternalTable(realSize);
		HashFunction function = HashFunctionFactory.createHashFunction(method,
				realSize);
		this.hashFunction = function;
	}

	// AUXILIARY
	/**
	 * It returns the prime number that is closest (and greater) to the given
	 * number.
	 * If the given number is prime, it is returned. 
	 * You can use the method Util.isPrime to check if a number is
	 * prime.
	 */
	int getPrimeAbove(int number) {
		while (!Util.isPrime(number))
			number++;

		return number;
	}

	@Override
	public void insert(T element) {
		int hash = getHash(element);
		LinkedList<T> elements = (LinkedList<T>) this.table[hash];

		if (elements != null) {
			this.COLLISIONS++;
		} else {
			this.table[hash] = new LinkedList<T>();
		}
		((LinkedList<T>) this.table[hash]).add(element);

		this.elements++;
	}

	private int getHash(T element) {
		try {
			return ((HashFunctionDivisionMethod<T>) this.hashFunction).hash(element);
		} catch (ClassCastException e) {
			return ((HashFunctionMultiplicationMethod<T>) this.hashFunction).hash(element);
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			int hash = getHash(element);
			LinkedList<T> objs = (LinkedList<T>) this.table[hash];

			if (objs != null) {
				objs.remove(element);
				this.elements--;
			}
		}
	}

	@Override
	public T search(T element) {
		if (element == null || this.isEmpty())
			return null;

		int hash = getHash(element);
		LinkedList<T> objs = (LinkedList<T>) this.table[hash];

		if (objs == null) {
			boolean containsElement = objs.contains(element);
			return containsElement ? element : null;
		}
		return null;
	}

	@Override
	public int indexOf(T element) {
		if (element == null || this.isEmpty())
			return -1;

		int hash = getHash(element);
		LinkedList<T> objs = (LinkedList<T>) this.table[hash];

		if (objs != null) {
			boolean containsElement = objs.contains(element);
			return containsElement ? hash : -1;
		}
		return -1;
	}

}
