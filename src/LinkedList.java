import java.util.NoSuchElementException;

/**
 * Implementation of linked list using java
 * @author Unmesh Chougule
 */
public class LinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        //empty list
        System.out.println("For empty list ->");
        System.out.println("Check if element '1' exists : "+list.exists(1));
        System.out.println("Check if element '1' removed : "+list.removeFirstOccurrence(1));
        System.out.println();

        //insert some elements
        list.insertAtEnd(5); // new head
        list.insertAtEnd(11);
        list.insertAtStart(22); // head changed
        list.insertAtEnd(13);
        list.insertAtEnd(1);
        list.insertAtEnd(99);

        System.out.println("Middle element of the list : "+list.findMiddle());
        System.out.println("Contents of the LinkedList : "+list);
        System.out.println("Size of the list : "+list.size());
        System.out.println();

        System.out.println("Check if element '11' exists : "+list.exists(11));
        System.out.println("Check if element '11' is removed : "+list.removeFirstOccurrence(11));
        System.out.println("After removal - contents of the LinkedList : "+list);
        System.out.println("After removal - Size of the list : "+list.size());
        System.out.println("Check if element at index '3' is removed : "+list.removeAt(3));
        System.out.println("After removal - contents of the LinkedList : "+list);
        System.out.println("After removal - Size of the list : "+list.size());
        System.out.println();

        System.out.println("Head of the list : "+list.getFirst());
        System.out.println("Tail of the list : "+list.getLast());
    }

    private int size = 0;
    private Node head = null;
    private Node tail = null;

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

    /**
     * Inserts element in linked list at start (as head)
     * @param element element to be inserted
     */
    public void insertAtStart(int element) {
        if (size == 0) { //empty list till now
            this.head = new Node(element, null);
            this.tail = this.head;
        } else { // one or more element already present, make this new node the head
            Node oldHead = this.head;
            this.head = new Node(element, null);
            this.head.next = oldHead;
        }
        size++;
    }

    /**
     * Removes element from specific index
     * @param index from where element is to be removed
     * @return removed element
     * @throws NoSuchElementException if empty list
     * @throws IndexOutOfBoundsException if invalid index passed
     */
    public int removeAt(int index) throws NoSuchElementException, IndexOutOfBoundsException {
        if (size == 0) { //empty list, nothing to remove
            throw new NoSuchElementException("List is empty!");
        }
        if (0 == index) { //removing head
            int element = this.head.value;
            if (this.tail == this.head) { //if only one element present, change tail value as well
                this.tail = this.tail.next;
            }
            this.head = this.head.next;
            size--;
            return element;
        }

        //flow for removing any other node than head
        Node currNode = this.head;
        Node nextNode = this.head.next;

        for (int i=1; i<size; i++) {
            if (i == index) {
                int element = nextNode.value;
                currNode.next = nextNode.next;
                if (this.tail == nextNode) { //if removing tail, change tail to point it to second last node
                    this.tail = currNode;
                }
                size--;
                return element;
            }
            currNode = currNode.next;
            nextNode = nextNode.next;
        }

        throw new IndexOutOfBoundsException("Invalid index passed!");
    }

    /**
     * Removes first occurrence of the element from the list if it exits
     * @param element element to be removed
     * @return true if element removed else false
     */
    public boolean removeFirstOccurrence(int element) {
        if (size == 0) { //empty list, nothing to remove
            return false;
        }
        if (this.head.value == element) { //removing head
            if (this.tail == this.head) { //if only one element present, change tail value as well
                this.tail = this.tail.next;
            }
            this.head = this.head.next;
            size--;
            return true;
        }

        //flow for removing any other node than head
        Node currNode = this.head;
        Node nextNode = this.head.next;

        for (int i=1; i<size; i++) {
            if (nextNode.value == element) {
                currNode.next = nextNode.next;
                if (this.tail == nextNode) { //if removing tail, change tail to point it to second last node
                    this.tail = currNode;
                }
                size--;
                return true;
            }
            currNode = currNode.next;
            nextNode = nextNode.next;
        }

        return false;
    }

    /**
     * Finds middle element in the list
     * @return middle element
     * @throws NoSuchElementException if empty list
     */
    public int findMiddle() throws NoSuchElementException {
        if (this.size == 0) {
            throw new NoSuchElementException("Empty list!");
        }

        //using two pointer (hair and tortoise to find middle point)
        Node tortoise = this.head;
        Node hair = this.head;

        //check next two elements are not null, so hair can jump two elements further
        while (hair.next != null && hair.next.next != null) {
            hair = hair.next.next;
            tortoise = tortoise.next;
        }

        return tortoise.value;
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

    /**
     * Get first element in the list
     * @return returns first value if the list is not empty
     * @throws NoSuchElementException if the list is empty
     */
    public int getFirst() throws NoSuchElementException {
        if (size > 0) {
            return this.head.value;
        }
        throw new NoSuchElementException("List is empty!");
    }

    /**
     * Get last element in the list
     * @return returns last+ value if the list is not empty
     * @throws NoSuchElementException if the list is empty
     */
    public int getLast() throws NoSuchElementException {
        if (size > 0) {
            return this.tail.value;
        }
        throw new NoSuchElementException("List is empty!");
    }

    /**
     * Get size of the list
     * @return size
     */
    public int size() {
        return this.size;
    }
}
