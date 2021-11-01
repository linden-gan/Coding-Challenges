import java.util.*;

public class IsCompleted {
   public static void main(String[] args) {
   
   }
   
   public boolean isCompleted(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isCompleted(root.left) && isCompleted(root.right);
    }
    
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(height(node.left), height(node.right)) + 1;
        }
    }
}