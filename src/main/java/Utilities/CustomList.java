package Utilities;

import CA.Show;

public class CustomList<D> {

    public class Node<D> {
        D data;
        public Node<D> next;

        Node(D d) {
            this.data = d;
            this.next = null;
        }
    }

    Node<D> head;

    public void add(D d) {
        if (head == null) {
            this.head = new Node<>(d);
        } else {
            Node<D> newN = new Node<>(d);
            Node<D> now = this.head;

            while (now.next != null) {
                now = now.next;
            }
            now.next = newN;
        }
    }

    public void remove(int i) {
        if (i == 0) {
            this.head = head.next;
        } else {
            int n = 1;
            Node<D> count = this.head;
            while (count != null) {
                if (n == i) {
                    count.next = count.next.next;
                    break;
                }
                count = count.next;
                n++;
            }
        }
    }
    public D getIndex(int index) {
        Node<D> current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }
        return null; // in case of invalid index
    }
    public int getSize() {
        int count = 0;
        Node<D> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println("Size of CustomList: " + count);
        return count;
    }
}