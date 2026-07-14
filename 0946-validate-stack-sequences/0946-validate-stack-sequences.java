import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int popIndex = 0; 
        for (int val : pushed) {
            s.push(val); 
         
            while (!s.isEmpty() && s.peek() == popped[popIndex]) {
                s.pop();
                popIndex++; 
            }
        }

       
        return s.isEmpty();
    }
}
