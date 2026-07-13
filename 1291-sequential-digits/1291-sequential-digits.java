class Solution {
    List<Integer> l = new ArrayList<>() ; 
    
    void  recur(int num , int lastDigit , int low , int high){
        if(high < num){
            return  ; 
        }
        if(low <= num){
            l.add(num) ; 
        }
        if(lastDigit == 9){
            return;
        }
       recur(num * 10 +(lastDigit +1), lastDigit +1, low , high);

    } 
    public List<Integer> sequentialDigits(int low, int high) {
     
        for(int i = 1 ; i<= 9 ; i++){
            recur(i , i , low , high) ; 
        }
        Collections.sort(l) ; 
        return l ; 
    }
}