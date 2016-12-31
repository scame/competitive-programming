package algo4th.fundamentals;


public class Node<T> {
    private T item;
    private Node next;

    public Node(T item) {
        this.item = item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public Node<T> getNext() {
        return next;
    }
}
