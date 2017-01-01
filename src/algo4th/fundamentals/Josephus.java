package algo4th.fundamentals;


public class Josephus {

    private static final int ONE_POSITION_LEFT = 1;

    private final LinkedListBasedQueue<Integer> positions;

    private final int eliminationFrequency;

    private final int personsNumber;

    public Josephus(int eliminationFrequency, int personsNumber) {
        this.positions = new LinkedListBasedQueue<>();
        this.eliminationFrequency = eliminationFrequency;
        this.personsNumber = personsNumber;
        fillQueue();
    }

    private void fillQueue() {
        for (int i = 0; i < personsNumber; i++) {
            positions.enqueue(i);
        }
    }

    public void printEliminationOrder() {

        for (int i = 1; positions.size() != ONE_POSITION_LEFT; i++) {
            if (i % eliminationFrequency == 0) {
                eliminatePosition();
            } else {
                moveToTheEnd();
            }
        }
        System.out.println("Safe position: " + positions.dequeue());
    }

    private void eliminatePosition() {
        int eliminated = positions.dequeue();
        System.out.println(eliminated);
    }

    private void moveToTheEnd() {
        int position = positions.dequeue();
        positions.enqueue(position);
    }

    public static void main(String[] args) {
        Josephus josephus = new Josephus(2, 7);
        josephus.printEliminationOrder();
    }
}
