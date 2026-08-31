import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int l = commands.length;
        
        int n = 0;
        
        int[] answer = new int[l];
        
        for(int i=0; i<l; i++) {
            
            int[] t = new int[commands[i][1]-commands[i][0]+1];
            
            int a = 0;
            
            for(int j=commands[i][0]-1; j<=commands[i][1]-1 ; j++){
                t[a] = array[j];
                a++;
            }
            
            Arrays.sort(t);
            
            answer[n] = t[commands[i][2]-1];
            
            n++;
        }
        
        return answer;
    }
}