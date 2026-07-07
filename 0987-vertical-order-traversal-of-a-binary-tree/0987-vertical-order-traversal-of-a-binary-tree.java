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
    Tuple(TreeNode node  ,int row , int col){
     this.node = node ;
      this.row = row ; 
      this.col = col ; 
    }
 }
 
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
TreeMap<Integer , TreeMap<Integer , PriorityQueue<Integer>>> map = new TreeMap<>() ; 
 Queue<Tuple>  q= new LinkedList<Tuple>() ; 
      q.add(new Tuple(root , 0 , 0) ) ; 
    while(!q.isEmpty()){
     Tuple t =  q.remove() ; 
     TreeNode curr = t.node ;
     int x = t.row  ; 
     int y = t.col ;
     if(!map.containsKey(x)){
       map.put(x, new TreeMap<>() ) ; 
     }
     if(!map.get(x).containsKey(y)){
        map.get(x).put(y, new PriorityQueue<Integer>()) ; 
     }
     map.get(x).get(y).add(curr.val) ;
     if(curr.left != null){
        q.add(new Tuple(curr.left , x -1 ,  y + 1)) ; 

     }
     if(curr.right != null){
        q.add(new Tuple(curr.right , x + 1 , y + 1)) ; 

     }
     
    }
    List<List<Integer>> l = new ArrayList<>() ; 
   for(TreeMap<Integer, PriorityQueue<Integer>> hs : map.values()){
     l.add(new ArrayList<>());
     for(PriorityQueue<Integer> pq : hs.values()){
        while(!pq.isEmpty()){
            System.out.println(pq.peek());
            l.get(l.size() - 1).add(pq.poll()) ;
        }
     }
   }
   return l ;
  
}
}
