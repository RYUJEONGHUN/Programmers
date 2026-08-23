import java.util.*;


class Solution {
    public boolean solution(String[] phone_book) {
        
        HashMap<String,Integer> m = new HashMap<>();
        
        for(String s : phone_book){
            m.put(s,1);
        }
        
        for(String s : phone_book){
            boolean c = false;
            int n = s.length();
            //String  = "";
            
            for(int i=1; i<n; i++){
                String prefix = s.substring(0,i);
                
                if(m.containsKey(prefix)){
                    return false;
                }
            }
        }
        return true;
    }
}