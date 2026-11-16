import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        
        int[] server = new int[24];
        
        int[] result = new int[24];
        
        
        for(int i=0;i<24;i++){
            
            int user = players[i];
            
            int needserverc = -1;
            for(int n=0;n<=1000;n++){
                if(user >= n*m && user < (n + 1)*m ){
                    needserverc = n;
                    break;
                }
            }
            
            int cserverc = server[i];
            
            if(needserverc > cserverc){
                int diff = needserverc - cserverc;
                
                result[i] = diff;
                
                for(int j=0;j<k;j++){
                    if( (i+j) <24 ){
                        server[i+j] = server[i+j] + diff;
                    }
                }
            }
            
        }
        
        int answer = 0;
        
        for(int i=0;i<24;i++){
            answer += result[i]; 
        }
        
        return answer;
    }
}