import java.util.NoSuchElementException;

/**
 * Implementation of stack using java - just using linked list to insert at first and get from first to imitate stack (LIFO) behavior
 * @author Unmesh Chougule
 */
public class Stack {

    private final LinkedList myLinkedList = new LinkedList();

    public static void main(String[] args) {
        Stack myStack = new Stack();

        myStack.push(2);
        myStack.push(55);
        myStack.push(14);

        System.out.println("Stack elements : "+myStack);
        System.out.println("Size : "+myStack.size());
        System.out.println("Get top element from stack : "+myStack.pop());
        System.out.println("See top element from stack : "+myStack.peek());
        System.out.println("Stack elements : "+myStack);
        System.out.println("Size : "+myStack.size());
    }

    /**
     * Adds element in stack
     * @param element to be inserted
     */
    public void push(int element) {
        myLinkedList.insertAtStart(element);
    }

    /**
     * Returns last inserted element from stack without removing it
     * @throws NoSuchElementException if stack is empty
     */
    public int peek() throws NoSuchElementException {
        return myLinkedList.getFirst();
    }

    /**
     * Returns last inserted element from stack and removes it
     * @throws NoSuchElementException if stack is empty
     */
    public int pop() throws NoSuchElementException {
        return myLinkedList.removeAt(0);
    }

    @Override
    public String toString() {
        return myLinkedList.toString();
    }

    /**
     * Get size of the stack
     * @return size
     */
    public int size() {
        return myLinkedList.size();
    }

}
