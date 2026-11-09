import java.util.*;
import java.lang.*;


class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        String[] answer = new String[n];
        
        
        for(int i=0;i<n;i++){
            int a = arr1[i];
            int b = arr2[i];
            
            int r = a | b;
            
            String rs = makebinary(n,r);
            
            String ts = "";
            
            for(int k=0;k<n;k++){
                if(rs.charAt(k)=='1'){
                    ts+='#';
                }else{
                    ts+=' ';
                }
            }
            answer[i] = ts;
        }
        
        
        return answer;
    }
    
    public static String makebinary(int n, int a){
        
        int index = 0;
        
        String s = "";
        
        while(a > 0){
            int r = a % 2;
            s = r + s;
            a /= 2;
        }
        
        int k = s.length();
        
        for(int i=0;i<n-k;i++){
            s = 0 + s;
        }
        
        System.out.println(s);

        return s;
    }
}