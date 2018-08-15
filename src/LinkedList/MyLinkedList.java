package LinkedList;

class MyLinkedList {

    int val = -1;
    MyLinkedList next;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
    }


    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        int currIndex = 0;
        MyLinkedList currNode = new MyLinkedList();
        currNode.val = this.val;
        currNode.next = this.next;

        if (index == 0) {
            return currNode.val;
            // int cannot be null; just return whatever is here
        }

        // should not reach code if index is 0
        for (int i = 0; i <= index; i++) {
            if (i == index) return currNode.val;
            if (currNode.next != null) currNode = currNode.next;
            else {
                break;
            }
        }
        return -1; // prone to error if while loop is bad
    }


    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (this.val == -1) { // if adding first node
            this.val = val;
            return;
        }
        MyLinkedList oldHead = new MyLinkedList();
        oldHead.val = this.val;
        oldHead.next = this.next;

        this.val = val;
        this.next = oldHead;
    }


    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        MyLinkedList currNode = this;

        while (currNode.next != null) {
            currNode = currNode.next; // traverse to node next
        }

        currNode.next = new MyLinkedList();
        currNode.next.val = val;

    }


    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            this.addAtHead(val);
        }
        if (index > 0 && this.get(0) == -1) { // if first node isn't initialized
            return;
        }

        MyLinkedList currNode = this;
        for (int i = 0; i <= index; i++) {
            if (i == index - 1) { // i is right before index
                MyLinkedList newNode = new MyLinkedList();
                newNode.val = val;
                newNode.next = currNode.next;
                currNode.next = newNode;
                return;
            }

            if (currNode.next == null) return; // stop case
            else currNode = currNode.next; // traverse to node next
        }
    }


    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index == 0) {
            this.val = this.next.val;
            this.next = this.next.next;
            return;
        }

        MyLinkedList prevNode = null;
        MyLinkedList currNode = this;
        if (currNode.next == null) return;
        else {
            prevNode = this;
            currNode = this.next; // traverse to node next
        }

        for (int i = 1; i <= index; i++) {
            if (i == index) {
                prevNode.next = currNode.next;
                return;
            }

            if (currNode.next == null) return; // stop case
            else {
                prevNode = currNode;
                currNode = currNode.next; // traverse to node next
            }
        }
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
