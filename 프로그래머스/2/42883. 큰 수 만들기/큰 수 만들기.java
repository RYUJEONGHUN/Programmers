import java.util.*;
import java.io.*;


class Solution {
    public String solution(String number, int k) {
        Stack<Character> st = new Stack<Character>();
        int count = 0;
        int l = number.length();
        
        st.push(number.charAt(0));
        
        for(int i=1;i<l;i++){
            char income = number.charAt(i);
            
            while(!st.isEmpty()){
                if(count<k){
                    char alreadycom = st.peek();
                
                    if((int)alreadycom >= (int)income){
                        st.push(income);
                        break;
                    }else{
                        st.pop();
                        count++;
                        if(st.isEmpty()){
                            st.push(income);
                            break;
                        }
                    }
                }else{
                    st.push(income);
                    break;
                }
            }  
        }
        while (count < k) {
            st.pop();
            count++;
        }
       
        
        String answer = "";
        
        while(!st.isEmpty()){
           String back = "" + st.pop();
           answer = back + answer; 
        }
        
        
        return answer;
    }
}