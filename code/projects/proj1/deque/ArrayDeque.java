package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size;
    private int capacity;
    private int frontPtr;
    private int rearPtr;

    public ArrayDeque() {
        size = 0;
        capacity = 8;
        items = (T[]) new Object[capacity];
        frontPtr = capacity / 2;
        rearPtr = frontPtr;
    }

    // Upon hitting capcity, resize up
    // Create new array with new capacity
    // Copy over original elements
    private void resizeUp() {
        int newCapacity = this.capacity * 2;
        T[] newArr = (T[]) new Object[newCapacity];
        int newFrontPtr = newCapacity/2;
        int newRearPtr = newFrontPtr;
        int newSize = 0;

        // update front, rear pointers and carry over items
        // loop from rear to pointer
        // use mod operation if reached start of orig array

        // or use removeLast() of orig array and addFirst() to new array
        // will need to create private helper methods that manipulate the array being passed in,
        // in order to manipulate both orig array and new array with the methods
        while(!isEmpty()) {
            T item = removeLast();
            newFrontPtr = addFirstToArray(newArr, item, newFrontPtr, newRearPtr);
            newSize++;
        }
        items = newArr;
        frontPtr = newFrontPtr;
        rearPtr = newRearPtr;
        capacity = newCapacity;
        size = newSize;
    }

    // Upon deleting items, resize it down

    private void resizeDown() {
        // TODO: complete this method
        capacity /= 2;
    }

    /** addFirst() helper method to update array based off of parameters being passed in*/
    private int addFirstToArray(T[] arr, T item, int frontPtr, int rearPtr) {
        int capacity = arr.length;
        if (arr[frontPtr] != null) {
            frontPtr--;
        }
        if (frontPtr < 0) {
            frontPtr = capacity-1;
        }
        arr[frontPtr] = item;
        // Front pointer needs to loop to end of array
        return frontPtr;
    }

    /**
     * @param item
     */
    @Override
    public void addFirst(T item) {
//        // Front pointer reached rear pointer or spot is already taken, resize array
//        if (frontPtr == rearPtr || items[frontPtr] != null) {
//        }
//        items[frontPtr] = item;
//        frontPtr--;
//        // Front pointer needs to loop to end of array
//        if (frontPtr < 0) {
//            frontPtr = capacity-1;
//        }
        if (size == capacity) {
            // resize
            resizeUp();
        }
        frontPtr = addFirstToArray(items, item, frontPtr, rearPtr);
        size++;
    }

    /** addLast() helper method to update array based off of parameters being passed in*/
    private int addLastToArray(T[] arr, T item, int frontPtr, int rearPtr) {
        int capacity = arr.length;
        if (arr[rearPtr] != null) {
            rearPtr++;
        }
        if (rearPtr == capacity) {
            rearPtr = 0;
        }
        arr[rearPtr] = item;
        // Rear ptr reached end of array, loop to start

        return rearPtr;
    }


    /**
     * @param item
     */
    @Override
    public void addLast(T item) {
        // Rear pointer reached front pointer or spot is already taken, resize array
//        if (rearPtr == frontPtr || items[rearPtr] != null) {
//
//        }
//        items[rearPtr] = item;
//        rearPtr++;
//        // Rear ptr reached end of array, loop to start
//        if (rearPtr == capacity) {
//            rearPtr = 0;
//        }
        if (size == capacity) {
            // resize
            resizeUp();
        }
        rearPtr = addLastToArray(items, item, frontPtr, rearPtr);
        size++;
    }

    /**
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *
     */
    @Override
    public void printDeque() {
        for (T item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }


    private T removeFirstToArr(T[] arr, int frontPtr, int rearPtr) {
        T returnItem = arr[frontPtr];
        arr[frontPtr] = null;
        frontPtr++;
        if (frontPtr == capacity-1) {
            frontPtr = 0;
        }
        this.frontPtr = frontPtr;
        return returnItem;
    }

    /**
     * @return
     */
    @Override
    public T removeFirst() {
        if (size == 0){
            return null;
        }
        T returnItem = removeFirstToArr(items, frontPtr, rearPtr);
        size--;
        return returnItem;
    }

    private T removeLastToArr(T[] arr, int frontPtr, int rearPtr) {
        int capacity = arr.length;
        T returnItem = arr[rearPtr];
        arr[rearPtr] = null;
        rearPtr--;
        if (rearPtr == 0) {
            rearPtr = capacity-1;
        }
        this.rearPtr = rearPtr;
        return returnItem;
    }

    /**
     * @return
     */
    @Override
    public T removeLast() {
        if (size == 0){
            return null;
        }
        T returnItem = removeLastToArr(items, frontPtr, rearPtr);
        size--;
        return returnItem;
    }

    /**
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        if (index >= capacity) {
            return null;
        }
        return items[index];
    }

    /**
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int pos;

        public ArrayDequeIterator() {
            pos = 0;
        }
        /**
         * @return
         */
        @Override
        public boolean hasNext() {
            return pos < capacity;
        }

        /**
         * @return
         */
        @Override
        public T next() {
            T returnItem = items[pos];
            pos++;
            return returnItem;
        }
    }
}
