class DLinkedNode {
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;
}

class LRUCache {

    private Map<Integer, DLinkedNode> cache = new HashMap();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    private void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode res = tail.prev;
        this.removeNode(res);
        return res;
    }

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.prev = null;

        tail = new DLinkedNode();
        tail.next = null;

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        
        DLinkedNode node = cache.get(key);
        if(node == null) {
            return -1;
        }

        this.moveToHead(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null) {

            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            count++;

            if(count > capacity) {
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                count--;
            }
        } else {
            node.value = value;
            this.moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */