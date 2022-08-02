import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Implementation of stack using only one queue
 *
 * @author Unmesh Chougule
 */
public class StackUsingOneQueue {

    private final Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) {
        StackUsingOneQueue stackUsingOneQueue = new StackUsingOneQueue();
        stackUsingOneQueue.push(4);
        stackUsingOneQueue.push(50);
        stackUsingOneQueue.push(1);
        stackUsingOneQueue.push(100);

        System.out.println("Size of the stack : "+stackUsingOneQueue.size());
        System.out.println("Elements in the stack : "+stackUsingOneQueue);
        System.out.println("Get top : "+stackUsingOneQueue.pop());
        System.out.println("Elements in the stack : "+stackUsingOneQueue);
        System.out.println("Peek top : "+stackUsingOneQueue.peek());
        System.out.println("Elements in the stack : "+stackUsingOneQueue);
    }

    /**
     * Adds element to stack
     * @param element element to be added
     */
    public void push(final int element) {
        queue.add(element);

        //re arrange all elements behind the new element inserted
        for (int i=0; i<size()-1; i++) {
            queue.add(queue.remove());
        }
    }

    /**
     * Removes and returns next element (top) from the stack
     * @return next element
     */
    public int pop() {
        return queue.remove();
    }

    /**
     * Returns next element (top) from the stack without removing it
     * @return next element
     */
    public int peek() {
        return queue.peek();
    }

    /**
     * Returns size of the stack
     * @return size
     */
    public int size() {
        return queue.size();
    }

    public String toString() {
        return queue.toString();
    }
}
