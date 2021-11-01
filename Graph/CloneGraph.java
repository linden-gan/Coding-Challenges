// Return a deep copy of the whole graph
class CloneGraph {
   /*
      The biggest take-away: apparently, using recursion is a good choice since a graph is a
      recursive structure. However, unlike tree, nodes in a graph are not directly connected by
      pointer. Usually we use adjacency list to represent the connection. So, it's hard to use
      x = change(x) to return a node. Also, some of the nodes are marked visited, so we can't include
      them... Anyway, the situation is far more complicated than expected to use recursion.
      So, the simplest strategy is to use Queue + while loop to implement BFS.
      Under this strategy, there's still one problem: we need to two queues and visited sets to keep
      track of both original and copied versions, so why not use a Map to associate each original node
      and copied node?
      Learn to use Map is important. When want to associate two types of things easily, remember Map!
   */
   Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        // K -> V : oldNode -> newNode
        Map<Node, Node> visited = new HashMap<>();
        
        // BFS initialization
        queue.add(node);
        visited.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node oldNode = queue.remove();
            for (Node oldChild : oldNode.neighbors) {
                if (!visited.containsKey(oldChild)) { // if it's a new node
                    visited.put(oldChild, new Node(oldChild.val)); // first produce the new node and store it in Map
                    queue.add(oldChild);
                }
                Node newNode = visited.get(oldNode);
                // no matter visited or not, a node must add all its neighbors
                newNode.neighbors.add(visited.get(oldChild));
            }
        }
        return visited.get(node);
    }
}