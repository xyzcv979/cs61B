package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T>{
    private MyLinkedList<T> myLL;

    public LinkedListDeque() {
        myLL = new MyLinkedList<>();
    }

    /**
     * @param item
     */
    @Override
    public void addFirst(T item) {
        myLL.addFirst(item);
    }

    /**
     * @param item
     */
    @Override
    public void addLast(T item) {
        myLL.addLast(item);
    }

    /**
     * @return
     */
    @Override
    public int size() {
        return myLL.size();
    }

    /**
     *
     */
    @Override
    public void printDeque() {
        // TODO: make MyLinkedList iterable for O(n) get(). This is O(n^2)
        for (int i = 0; i < size(); i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    /**
     * @return
     */
    @Override
    public T removeFirst() {
        if (size() == 0) {
            return null;
        }
        return myLL.removeFirst();
    }

    /**
     * @return
     */
    @Override
    public T removeLast() {
        if (size() == 0) {
            return null;
        }
        return myLL.removeLast();
    }

    /**
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        return myLL.get(index);
    }

    /**
     * Same as get method but uses recursion
     * @param index
     * @return
     */
    public T getRecursive(int index) {
        return getRecursiveHelper(index, myLL.getHead());
    }

    private T getRecursiveHelper(int index, MyLinkedList.MyLLNode<T> node) {
        if (node == null) {
            return null;
        }
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(index-1, node.next);
    }

    /**
     * Returns whether the parameter o is equal to the deque
     * @param o
     * @return
     */
    public boolean equals(Object o) {
        if (!(o instanceof LinkedListDeque) || myLL.size() != ((LinkedListDeque<?>) o).size()) {
            return false;
        }

        for (int i = 0; i < myLL.size(); i++) {
            if (!myLL.get(i).equals(((LinkedListDeque<?>) o).get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new LLDequeIterator();
    }

    private class LLDequeIterator implements Iterator<T> {
        private int pos;

        public LLDequeIterator() {
            pos = 0;
        }

        /**
         * @return
         */
        @Override
        public boolean hasNext() {
            return pos < size();
        }

        /**
         * @return
         */
        @Override
        public T next() {
            T returnItem = get(pos);
            pos++;
            return returnItem;
        }
    }
}
