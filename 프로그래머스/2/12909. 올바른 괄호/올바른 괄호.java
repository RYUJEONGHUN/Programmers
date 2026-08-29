import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Integer> stack = new ArrayDeque<Integer>();
        
        int l = s.length();
        
        for(int i=0; i<l; i++){
            if(s.charAt(i)=='('){
                stack.push(1);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }
        
        if(!stack.isEmpty()){
            return false;
        }
        
        return answer;
    }
}