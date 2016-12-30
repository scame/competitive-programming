package algo4th.fundamentals;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListBasedStack<T>  implements Iterable<T> {

    private Node first;

    private int nodeNumbers;

    private class Node {
        private T item;
        private Node next;

        private Node(T item) {
            this.item = item;
        }
    }

    public void push(T item) {
        Node oldHead = first;
        first = new Node(item);
        first.next = oldHead;
        ++nodeNumbers;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = first.item;
        first = first.next;
        --nodeNumbers;
        return item;
    }

    public int size() {
        return nodeNumbers;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T item = current.item;
                current = current.next;
                return item;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
