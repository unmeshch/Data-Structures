import java.util.NoSuchElementException;

/**
 * Implementation of queue using two stacks internally
 * @author Unmesh Chougule
 */
public class QueueUsingStack {

    private final Stack stack1 = new Stack();
    private final Stack stack2 = new Stack();

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
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
        if (stack1.size() == 0) { //empty queue, add directly in first stack
            stack1.push(element);
            return;
        }
        //not empty queue, maintain queue order by adding element at last position
        int stack1Size = stack1.size();
        for (int i=0; i<stack1Size; i++) {
            stack2.push(stack1.pop());
        }

        stack2.push(element);

        int stack2Size = stack2.size();
        for (int i=0; i<stack2Size; i++) {
            stack1.push(stack2.pop());
        }
    }

    /**
     * Get next element from queue
     * @return next element
     * @throws NoSuchElementException if queue is empty
     */
    public int get() throws NoSuchElementException {
        return stack1.pop();
    }

    @Override
    public String toString() {
        return stack1.toString();
    }

    /**
     * Get size of the queue
     * @return size
     */
    public int size() {
        return stack1.size();
    }
}