

/**
 * Implementation of linked list using java - maintains insertion order
 * @author Unmesh Chougule
 */
public class LinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println("Check if element '1' exists : "+list.exists(1));

        list.insertAtEnd(5);
        list.insertAtEnd(11);
        list.insertAtEnd(2);
        System.out.println("Contents of the LinkedList : "+list);

        System.out.println("Size of the list : "+list.size);
        System.out.println("Check if element '5' exists : "+list.exists(5));
        System.out.println("Check if element '11' exists : "+list.exists(5));
        System.out.println("Check if element '2' exists : "+list.exists(5));
    }

    int size = 0;
    Node head = null;
    Node tail = null;

    /**
     * Key element of the linked list structure, holds actual value and reference of the next node
     */
    private class Node {
        int value;
        Node next;
        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * Inserts element in linked list at the end
     * @param element element to be inserted
     */
    public void insertAtEnd(int element) {
        if (size == 0) { //empty list till now
            this.head = new Node(element, null);
            this.tail = this.head;
        } else { // one or more element already present, add new node next to tail
            Node newTail = new Node(element, null);
            this.tail.next = newTail;
            this.tail = newTail;
        }
        size++;
    }

    /** TODO : implement remove method
     * Removes element from the list if it exits
     * @param element element to be removed
     */
    public void removeElement(int element) {
        
    }

    /**
     * Check if the given element is present in the list
     * @param element element to be searched
     * @return true if it exists else false
     */
    public boolean exists(int element) {
        Node nodeToCompareValue = this.head;
        boolean elementFound = false;
        for (int i=0; i<size; i++) {
            if (nodeToCompareValue.value == element) {
                elementFound = true;
                break;
            }
            nodeToCompareValue = nodeToCompareValue.next;
        }
        return elementFound;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node nodeToCompareValue = this.head;
        for (int i=0; i<size; i++) {
            sb.append(nodeToCompareValue.value);
            sb.append(" ");
            nodeToCompareValue = nodeToCompareValue.next;
        }
        return sb.toString();
    }
}
