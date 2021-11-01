import java.util.*;

public class ConnectParallelNodes {
   public static void main(String[] args) {
   }
   
   public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> layer = new LinkedList<>(); // Similar to Broad-First Search
        layer.add(root);
        int num = 1;
        while (layer.peek().left != null) {
            for (int count = 1; count <= num; count++) {
                Node node = layer.remove();
                layer.add(node.left);
                layer.add(node.right);
            }
            num *= 2;
            boolean haji = true;
            Node left = null;
            for (Node node : layer) {
                if (!haji) {
                    left.next = node;
                    left = node;
                } else {
                    haji = false;
                    left = node;
                }
            }
        }
        return root;
    }
}