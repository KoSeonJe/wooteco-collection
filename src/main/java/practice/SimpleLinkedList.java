package practice;

import java.util.Objects;

public class SimpleLinkedList implements SimpleList {

    private Node head;
    private int size;

    class Node {

        private String value;
        private Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public boolean add(String value) {
        Node newNode = new Node(value, null);

        if (size == 0) {
            head = newNode;
            size++;
            return true;
        }
        Node node = head;

        while (node.next != null) {
            node = node.next;
        }

        node.next = newNode;
        size++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        Node newNode = new Node(value, null);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        Node foundNode = findNode(index - 1);
        newNode.next = foundNode.next;
        foundNode.next = newNode;
        size++;
    }

    @Override
    public String set(int index, String value) {
        Node node = findNode(index);
        node.value = value;
        return value;
    }

    @Override
    public String get(int index) {
        Node temp = findNode(index);
        return temp.value;
    }

    @Override
    public boolean contains(String value) {
        Node node = head;
        while (node.next != null) {
            if (Objects.equals(node.value, value)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        Node node = head;
        int index = 0;
        while (node.next != null) {
            if (Objects.equals(node.value, value)) {
                return index;
            }
            node = node.next;
            index++;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(String value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }

        remove(index);
        return true;
    }

    @Override
    public String remove(int index) {
        if (index == 0) {
            String removeValue = head.value;
            head = head.next;
            size--;
            return removeValue;
        }

        Node foundNode = findNode(index - 1);
        String removeValue = foundNode.next.value;
        foundNode.next = foundNode.next.next;
        size--;
        return removeValue;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    private Node findNode(int index) {
        validateSize(index);
        Node temp = head;
        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    private void validateSize(int index) {
        if (size <= index) {
            throw new IndexOutOfBoundsException("범위 밖입니다");
        }
    }
}
