import java.util.NoSuchElementException;

/**
 * TODO
 * Implementation of queue using two stacks internally
 * @author Unmesh Chougule
 */
public class QueueUsingOneStack {

    private final Stack stack = new Stack();

    public static void main(String[] args) {
        QueueUsingOneStack queue = new QueueUsingOneStack();
        queue.add(5);
        queue.add(3);
        queue.add(12);
        queue.add(21);

        System.out.println("Queue elements : "+queue);
        System.out.println("Size of the queue : "+queue.size());
        System.out.println("Get next element from queue : "+queue.get());
        System.out.println("Queue elements : "+queue);
        System.out.println("Size of the queue : "+queue.size());
    }

    /**
     * Adds element to the queue
     * @param element to be added
     */
    public void add(int element) {

    }

    /**
     * Get next element from queue
     * @return next element
     * @throws NoSuchElementException if queue is empty
     */
    public int get() throws NoSuchElementException {
        return stack.pop();
    }

    @Override
    public String toString() {
        return stack.toString();
    }

    /**
     * Get size of the queue
     * @return size
     */
    public int size() {
        return stack.size();
    }
}