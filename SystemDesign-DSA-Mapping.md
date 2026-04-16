# Day 20 — System Design with DSA

## DSA → Production Mapping
- HashMap → Caching (Redis)
- LinkedList → LRU Cache eviction
- Queue → Kafka/RabbitMQ message brokers
- Stack → Undo/Redo systems
- BST/B-Tree → Database indexes
- Heap → Priority queues, scheduling
- Graph + Dijkstra → Route optimization
- Trie → Autocomplete search
- DP → Optimization problems

## ShopFlow DSA Architecture
- Product search → B-Tree index O(log n)
- Autocomplete → Trie O(L)
- Order processing → Kafka Queue FIFO
- VIP orders → Heap priority O(log n)
- Delivery routes → Dijkstra O((V+E) log V)
- Session cache → HashMap O(1)
- Bulk edit undo → Stack O(1)
EOF
