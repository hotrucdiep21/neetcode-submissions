class DoublyNode {
    int data;
    DoublyNode prev;
    DoublyNode next;

    DoublyNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
class MyLinkedList {
    DoublyNode head;
    DoublyNode tail;
    int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        DoublyNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    public void addAtHead(int val) {
        DoublyNode newNode = new DoublyNode(val);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
        return;
    }

    public void addAtTail(int val) {
        DoublyNode newNode = new DoublyNode(val);
        if (size == 0) {
            addAtHead(val);
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
        return;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        DoublyNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        DoublyNode newNode = new DoublyNode(val);
        curr.prev.next = newNode;
        newNode.prev = curr.prev;
        newNode.next = curr;
        curr.prev = newNode;
        size++;
        return;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (size == 1) {
            head = tail = null;
            size--;
            return;
        }

        if (index == 0) {
            head = head.next;
            head.prev = null;
            size--;
            return;
        }

        if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
            size--;
            return;
        }

        DoublyNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        size--;
        return;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */