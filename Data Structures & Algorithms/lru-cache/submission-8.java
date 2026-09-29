class LRUCache {
    private static class Node {
        private Node prev;
        private Node next;
        private int key;
        private int value;

        private Node(int key) {
            this.key = key;
            this.value = value;
        }
    }

    private final HashMap<Integer, Node> cache;
    private final int capacity;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<Integer, Node>();
        this.capacity = capacity;
    }
    
    private Node getNode(int key) {
        Node node = cache.get(key);

        if (node == null) {
            return null;
        }

        if (node == tail) {
            return node;
        }

        if (node == head) {
            head = head.next;
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;

            return node;
        }

        tail.next = node;
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.prev = tail;
        tail = node;
        tail.next = null;

        return node;
    }

    public int get(int key) {
        Node node = getNode(key);

        if (node == null) {
            return -1;
        }

        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = getNode(key);

        if (node == null) {
            if (cache.size() == capacity && head != null) {
                cache.remove(head.key);

                head = head.next;

                if (head == null) {
                    tail = null;
                }
            }

            node = new Node(key);

            cache.put(key, node);

            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }

        node.value = value;
    }
}
