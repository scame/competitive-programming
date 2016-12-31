package algo4th.fundamentals;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class BasicStructsIterator<T> implements Iterator<T> {

    private Node<T> current;

    public BasicStructsIterator(Node<T> node) {
        current = node;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T item = current.getItem();
        current = current.getNext();
        return item;
    }
}
