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

    public T peek() {
        if (isEmpty()) {
            throw  new EmptyStackException();
        }
        return first.getItem();
    }

    public boolean find(T target) {
        for (T elem : this) {
            if (elem.equals(target)) {
                return true;
            }
        }
        return false;
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

    public static <E> LinkedListBasedStack<E> copy(LinkedListBasedStack<E> source) {
        LinkedListBasedStack<E> reverseStack = new LinkedListBasedStack<>();
        LinkedListBasedStack<E> copy = new LinkedListBasedStack<>();

        for (E element : source) {
            reverseStack.push(element);
        }
        for (E element : reverseStack) {
            copy.push(element);
        }
        return copy;
    }
}
