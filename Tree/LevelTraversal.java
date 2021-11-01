class LevelTraversal {
   public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, 0, root);
        return result;
    }
    
    private void helper(List<List<Integer>> result, int level, TreeNode root) {
        if (root == null) {
            return;
        }
        if (level == result.size()) { // make a new array if there's not
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        helper(result, level + 1, root.left);
        helper(result, level + 1, root.right);
    }
}
