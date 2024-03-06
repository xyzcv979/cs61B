package deque;

/**
 * My own Linked List implementation.
 * It is a doubly linked list using circular sentinel topology
 * Which is having a sentinel nodes for front and rear of the list
 * Additionally, each node has pointers to next and previous making it doubly
 */
public class MyLinkedList<T> implements MyList<T>{
    private int size;
    private final MyLLNode<T> frontSentinel;
    private final MyLLNode<T> rearSentinel;

    public static class MyLLNode<T> {
        public T item;
        public MyLLNode<T> next;
        public MyLLNode<T> prev;

        public MyLLNode(T item) {
            this.item = item;
            next = null;
            prev = null;
        }

        public MyLLNode() {
            this.item = null;
            next = null;
            prev = null;
        }
    }

    public MyLinkedList() {
        size = 0;
        frontSentinel = new MyLLNode<>();
        rearSentinel = new MyLLNode<>();
        frontSentinel.next = rearSentinel;
        frontSentinel.prev = rearSentinel;
        rearSentinel.prev = frontSentinel;
        rearSentinel.next = frontSentinel;
    }

    public MyLinkedList(T item) {
        size = 1;
        MyLLNode<T> first = new MyLLNode<>(item);
        frontSentinel = new MyLLNode<>();
        rearSentinel = new MyLLNode<>();
        frontSentinel.next = first;
        frontSentinel.prev = rearSentinel;
        first.prev = frontSentinel;
        rearSentinel.prev = first;
        rearSentinel.next = frontSentinel;
    }

    /**
     * Adds the newNode in front oldNode
     */
    private void add(MyLLNode<T> oldNode, MyLLNode<T> newNode) {
        MyLLNode<T> nextOldNode = oldNode.next;
        oldNode.next = newNode;
        newNode.prev = oldNode;
        newNode.next = nextOldNode;
        nextOldNode.prev = newNode;
        size++;
    }

    private void delete(MyLLNode<T> deleteNode) {
        MyLLNode<T> prev = deleteNode.prev;
        MyLLNode<T> next = deleteNode.next;
        prev.next = next;
        next.prev = prev;
        size--;
    }

    /**
     * @param x
     */
    @Override
    public void addLast(T x) {
        MyLLNode<T> currLastNode = rearSentinel.prev;
        MyLLNode<T> newNode = new MyLLNode<>(x);
        add(currLastNode, newNode);
    }

    /**
     * @return
     */
    @Override
    public T getLast() {
        return (T) rearSentinel.prev.item;
    }

    /**
     * @param i
     * @return
     */
    @Override
    public T get(int i) {
        if (i >= size) {
            return null;
        }
        T returnItem = null;
        MyLLNode<T> head = frontSentinel.next;
        while (i >= 0) {
            returnItem = head.item;
            head = head.next;
            i--;
        }
        return returnItem;
    }

    public MyLLNode<T> getHead() {
        return frontSentinel.next;
    }

    /**
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return
     */
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        MyLLNode<T> nodeToDelete = rearSentinel.prev;
        delete(nodeToDelete);
        T tmp = (T) nodeToDelete.item;
        nodeToDelete = null;
        return tmp;
    }

    /**
     * @param x
     * @param i
     */
    @Override
    public void insert(T x, int i) {
        if (frontSentinel.next == null || i == 0) {
            addFirst(x);
            return;
        }
        MyLLNode<T> head = frontSentinel;
        MyLLNode<T> newNode = new MyLLNode<>(x);
        while (i > 0 && head.next != null) {
            head = head.next;
            i--;
        }
        add(head, newNode);
    }

    /**
     * @param x
     */
    @Override
    public void addFirst(T x) {
        MyLLNode<T> newNode = new MyLLNode<>(x);
        add(frontSentinel, newNode);
    }

    /**
     * @return
     */
    @Override
    public T getFirst() {
        if (size == 0) {
            return null;
        }
        return (T) frontSentinel.next.item;
    }

    /**
     * @return
     */
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        MyLLNode<T> nodeToDelete = frontSentinel.next;
        delete(nodeToDelete);
        T tmp = (T) nodeToDelete.item;
        nodeToDelete = null;
        return tmp;
    }

}
