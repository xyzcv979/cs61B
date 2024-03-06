package deque;

public interface Deque<T> {
    /** Adds an item of TYpe T to the front of the deque */
    public void addFirst(T item);

    /** Adds an item of type T to the back of the deque */
    public void addLast(T item);

    /** Returns true if deque is empty, false otherwise */
    default public boolean isEmpty() {
        return size() == 0;
    }

    /** Returns the number of items in the deque */
    public int size();

    /** Prints the items in the deque from first to last, seperated by a space */
    public void printDeque();

    /** Removes and returns the item at the front of the deque, if no such item exists, return null */
    public T removeFirst();

    /** Removes and returns the item at the back of the deque, if no such item exists, return null */
    public T removeLast();

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *  If no such item exists, return null. Must not alter the deque*/
    public T get(int index);
}
