package algo4th.fundamentals;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListBasedQueue<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;

    private int nodeNumbers;

    public void enqueue(T item) {
        Node<T> oldTail = tail;
        tail = new Node<>(item);

        if (isEmpty()) {
            head = tail;
        } else {
            oldTail.setNext(tail);
        }
        ++nodeNumbers;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T item = head.getItem();
        head.setNext(head.getNext());
        if (isEmpty()) {
            tail = null;
        }
        --nodeNumbers;
        return item;
    }

    public int size() {
        return nodeNumbers;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new BasicStructsIterator<>(head);
    }

    public static void main(String[] args) {
        LinkedListBasedQueue<Integer> queue = new LinkedListBasedQueue<>();
        queue.enqueue(1);
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(33);

        for (Integer number : queue) {
            System.out.println(number);
        }
    }
}
