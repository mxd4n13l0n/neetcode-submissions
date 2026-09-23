class LRUCache(capacity: Int) {
    val cap = capacity
    val cache = mutableMapOf<Int, Node>()
    val head = Node(0, 0)
    val tail = Node(0, 0)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        if (!cache.contains(key)) {
            return -1
        }
        val recoveredNode = cache[key]!!
        markNodeAsMostRecent(recoveredNode)
        return recoveredNode.value
    }

    fun put(key: Int, value: Int) {
        if (cache.contains(key)) {
            val recoveredNode = cache[key]!!
            recoveredNode.value = value
            markNodeAsMostRecent(recoveredNode)
        } else {
            if (cache.size >= cap) {
                removeOldestNode()
            }
            val newNode = Node(key, value)
            cache[key] = newNode
            addNode(newNode)
        }
    }

    private fun addNode(node: Node) {
        node.next = head.next
        node.prev = head
        head.next?.prev = node
        head.next = node
    }

    private fun removeNode(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    private fun markNodeAsMostRecent(node: Node) {
        removeNode(node)
        addNode(node)
    }

    private fun removeOldestNode() {
        val oldest = tail.prev ?: return
        cache.remove(oldest.key)
        removeNode(oldest)
    }
}

data class Node(
    val key: Int,
    var value: Int, 
    var prev: Node? = null, 
    var next: Node? = null
)