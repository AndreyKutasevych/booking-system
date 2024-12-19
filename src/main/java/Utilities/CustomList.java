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
}