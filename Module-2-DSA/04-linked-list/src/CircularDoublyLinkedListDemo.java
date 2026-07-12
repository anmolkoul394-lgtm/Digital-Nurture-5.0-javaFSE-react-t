// CircularDoublyLinkedListDemo.java
// Demonstrates a Circular Doubly Linked List: combines both ideas -
// each node has "next" AND "prev" pointers, AND the last node's "next"
// points back to head while head's "prev" points to the last node.
// Supports: insert (at end), traverse, search, delete (by value).

class CDLLNode {
    int data;
    CDLLNode next;
    CDLLNode prev;

    CDLLNode(int data) {
        this.data = data;
    }
}

class CircularDoublyLinkedList {
    private CDLLNode head;

    // Insert a new node at the end, keeping the circle and both links intact.
    public void insert(int data) {
        CDLLNode newNode = new CDLLNode(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
            return;
        }
        CDLLNode last = head.prev; // last node is head's "prev" in a circular DLL

        last.next = newNode;
        newNode.prev = last;
        newNode.next = head;
        head.prev = newNode;
    }

    // Traverse forward exactly once around the circle.
    public void traverse() {
        StringBuilder sb = new StringBuilder("Circular Doubly Linked List: ");
        if (head == null) {
            System.out.println(sb + "(empty)");
            return;
        }
        CDLLNode current = head;
        do {
            sb.append(current.data).append(" <-> ");
            current = current.next;
        } while (current != head);
        sb.append("(back to head)");
        System.out.println(sb);
    }

    // Search for a value by walking once around the circle.
    public boolean search(int target) {
        if (head == null) {
            return false;
        }
        CDLLNode current = head;
        do {
            if (current.data == target) {
                return true;
            }
            current = current.next;
        } while (current != head);
        return false;
    }

    // Delete the first node matching the given value.
    public void delete(int target) {
        if (head == null) {
            return;
        }
        CDLLNode current = head;
        do {
            if (current.data == target) {
                if (current.next == current) {
                    // Only one node in the list
                    head = null;
                    return;
                }
                current.prev.next = current.next;
                current.next.prev = current.prev;
                if (current == head) {
                    head = current.next; // move head if we deleted the head node
                }
                return;
            }
            current = current.next;
        } while (current != head);
    }
}

public class CircularDoublyLinkedListDemo {
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);

        list.traverse();

        System.out.println("Searching for 20: " + (list.search(20) ? "Found" : "Not Found"));

        System.out.println("Deleting 20...");
        list.delete(20);

        System.out.print("After deletion -> ");
        list.traverse();
    }
}
