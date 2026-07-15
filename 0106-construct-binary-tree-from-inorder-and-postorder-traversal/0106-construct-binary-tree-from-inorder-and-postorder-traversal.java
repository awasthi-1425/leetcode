import java.util.*;

class Solution {
    public int postIdx ; 
    public Map<Integer, Integer> map = new HashMap<>() ; 
        
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         postIdx = postorder.length - 1  ; 
    
      for(int i = 0 ; i < inorder.length ; i++){
        map.put(inorder[i], i ) ; 
      }
      return build( postorder, 0 , inorder.length - 1 ) ;

    }
    public TreeNode build(int postorder[] , int inL , int inR){
       
        if(inL > inR){
            return null ;
        }
       int rootVal = postorder[postIdx--] ; 
       TreeNode root = new TreeNode(rootVal); 
       int idx = map.get(rootVal) ; 
       root.right = build(postorder , idx+ 1 , inR) ; 
       root.left  = build(postorder, inL , idx -1 ) ;
       return root ; 
    }

   
}
