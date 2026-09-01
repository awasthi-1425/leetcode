/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res =  new ArrayList<>() ; 
        if(root == null) return res ; 
        dfs(root , targetSum , new ArrayList<>() , res ) ;
        return res; 
    }
    public void dfs(TreeNode node , int rem , List<Integer> path ,List<List<Integer>> res){
        path.add(node.val) ;
        if(node.left == null && node.right == null){
            if(rem - node.val == 0){
                res.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1) ;
            return  ; 
        }
        if(node.left != null){
            dfs(node.left, rem- node.val, path, res);
        }
        if(node.right != null){
            dfs(node.right , rem - node.val ,path , res); 
        }
        path.remove(path.size() - 1);
        
    }
}