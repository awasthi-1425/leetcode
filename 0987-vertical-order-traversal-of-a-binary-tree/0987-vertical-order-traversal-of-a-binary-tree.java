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
 
class Tuple{
    TreeNode node ; 
    int row ;
    int col ; 
    Tuple(TreeNode node , int row, int col){
        this.node = node ;
        this.row = row ;
        this.col = col  ; 
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root){
     TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
      Queue<Tuple> q = new LinkedList<>();
      q.add(new Tuple(root, 0 , 0)) ;
      while(!q.isEmpty()){
        Tuple curr = q.remove() ; 
        TreeNode k = curr.node ; 
        int x = curr.row ;
        int y= curr.col ;
        if(!map.containsKey(x)){
            map.put(x, new TreeMap<>()) ;

        }
        if(!map.get(x).containsKey(y)){
            map.get(x).put(y , new PriorityQueue<>()) ; 

        }
        map.get(x).get(y).add(k.val) ; 
        if(k.left != null){
            q.add(new Tuple(k.left , x - 1 , y + 1)) ;
        }
        if(k.right != null){
            q.add(new Tuple(k.right , x + 1 , y + 1)) ; 
        }
        
      }
      List<List<Integer>> l = new ArrayList<>() ; 
      for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()){
        l.add(new ArrayList<>()) ; 
        for(PriorityQueue<Integer> node : ys.values()){
            while(!node.isEmpty()){
                System.out.println(node.peek());
                l.get(l.size() - 1).add(node.poll());
            }
        }
      }
      return l;



  }
}
