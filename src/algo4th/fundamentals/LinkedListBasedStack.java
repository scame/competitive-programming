package algo4th.fundamentals;

import java.util.EmptyStackException;
import java.util.Iterator;

public class LinkedListBasedStack<T>  implements Iterable<T> {

    private Node<T> first;

    private int nodeNumbers;

    public void push(T item) {
        Node<T> oldHead = first;
        first = new Node<>(item);
        first.setNext(oldHead);
        ++nodeNumbers;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = first.getItem();
        first = first.getNext();
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
        return new BasicStructsIterator<>(first);
    }
}
