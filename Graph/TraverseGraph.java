class TraverseGraph {

   // We want to use BFS to traverse the whole graph
   void traverse(Node root) {
      Set<Node> visited = new HashSet<>(); // memorize visited node
      Queue<Node> queue = new LinkedList<>(); // tool for BFS
      
      // Initialize
      queue.add(root);
      
      while (!queue.isEmpty()) {
         Node cur = queue.remove();
         visited.add(cur); // memorize it
         System.out.println(cur);
         
         for (Node child : cur.children) {
            if (!visited.contains(child)) {
               queue.add(child); // add this child to queue
            }
         }
      }
   }
}