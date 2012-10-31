/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.nandana.examples.list;

import java.util.Arrays;

/**
 * A class that maintains a list of integers 
 *
 */
public class IntegerList {
	
	/**
	 * The array where are the elements of the list are stored.
	 */
	private transient int[] elements;

	/**
	 * The current size of the list
	 * 
	 * @serial
	 */
	private int size = 0;

	private int capacity;
	
	private SortOrder sortOrder;

	public IntegerList(int initialCapacity) {

		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: "
					+ initialCapacity
					+ ". Capacity can not be a negative value.");

		capacity = initialCapacity;
		this.elements = new int[initialCapacity];
	}

	/**
	 * Appends the integer to the end of this list.
	 * 
	 * @param e
	 *            element to be appended to this list
	 * @return <tt>true</tt>
	 */
	public boolean add(int e) {
		ensureNotFull();
		elements[size++] = e;	
		return true;
	}

	private void ensureNotFull() {
		if (size >= capacity) {
			throw new IllegalStateException(
					"Illegal Operation: the list is already full");
		}
	}

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index
	 *            index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException
	 */
	public int get(int index) {
		return elements[index];
	}

	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left (subtracts one from their indices).
	 * 
	 * @param index
	 *            the index of the element to be removed
	 * @return the element that was removed from the list
	 * @throws IndexOutOfBoundsException
	 *             {@inheritDoc}
	 */
	public int remove(int index) {

		int oldValue = elements[index];

		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(elements, index + 1, elements, index, numMoved);
		elements[--size] = 0;

		return oldValue;
	}
	
	public void sort(SortOrder order){
		if (SortOrder.ASCENDING.equals(order)) {
			// sort the array from index 0 to size (exclusive)
			Arrays.sort(elements, 0, size);
		} else if (SortOrder.DESCENDING.equals(order)) {
			sortDescending();
		} 
	}
	
	public void sort() {
		sort(sortOrder);
	}
	
	public void setOrder(SortOrder sortOrder){
		this.sortOrder = sortOrder;
	}
	
	@Override
	public String toString(){
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("[");
		for (int i : elements){
			strBuf.append(i+",");
		}
		strBuf.append("]");
		
		return strBuf.toString();
	}
	
	private void sortDescending() {
		
		int[] descendingList = new int[capacity];
		
		//First sort ascending from index 0 to size (exclusive)
		Arrays.sort(elements, 0, size);
		
		//reversing the order
		for (int i = 0 ; i < size; i++) {
			descendingList[size-1-i] = elements[i];
		}
		
		elements = descendingList;
				
	}

}
