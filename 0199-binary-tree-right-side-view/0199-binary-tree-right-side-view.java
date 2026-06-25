import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
     ArrayList<Integer> arr = new ArrayList<>() ;
     recur(root , arr , 0) ;
     return arr ;  
    }
   public void recur(TreeNode root,  ArrayList<Integer> arr ,  int level){
    if(root == null){
        return ; 
    }
    if(level == arr.size()){
        arr.add(root.val) ;
    }
    recur(root.right ,  arr,  level + 1 ) ;
    recur(root.left ,  arr,  level + 1 ) ; 
   }
}