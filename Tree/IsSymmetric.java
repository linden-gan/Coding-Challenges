import java.util.*;

// Whether a tree is symmetric with respect of its middle axis
// Symmetric: same node with same value.
public class IsSymmetric {
   public static void main(String[] args) {
   
   }
   
   public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if ((left == null && right != null) ||
                   (left != null && right == null)) {
            return false;
        } else {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left)
                   && left.val == right.val;
        }
    }
}