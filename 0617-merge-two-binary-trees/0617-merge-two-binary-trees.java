class Solution {
    public TreeNode mergeTrees(TreeNode tree1, TreeNode tree2) {
        
        if (tree1 == null && tree2 == null) {
            return null;
        }
        
        if (tree1 == null) {
            return tree2;
        }
        if (tree2 == null) {
            return tree1;
        }
        
        
        TreeNode merged = new TreeNode(tree1.val + tree2.val);
       
        merged.left = mergeTrees(tree1.left, tree2.left);
        merged.right = mergeTrees(tree1.right, tree2.right);
        
        return merged;
    }
}