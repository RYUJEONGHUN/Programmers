import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        
        int[][] fatigue = { {1,1,1},{5,1,1},{25,5,1} };
            
        int sum = 0;
        
        for(int i=0;i<3;i++){
            sum+=picks[i];
        }
        
        int limit = Math.min(minerals.length,sum*5);
        
        List<int []> group = new ArrayList<int []>();
        
        for(int i=0;i<=limit;i+=5){
            
            int[] count = new int[3];
            
            for(int j=i;j<Math.min(i+5,limit);j++){
                switch(minerals[j]){
                    case "diamond":
                        count[0]++;
                        break;
                    case "iron":
                        count[1]++;
                        break;
                    case "stone":
                        count[2]++;
                        break;
                }
            }
            group.add(count);
        }
        
        group.sort((a,b) -> {
           if(a[0]!=b[0]){
               return Integer.compare(b[0],a[0]);
           }
            return Integer.compare(b[1], a[1]);
        });
        
        int answer = 0;
        int index = 0;
        
        for(int pick=0; pick<3; pick++){
            
            while(picks[pick] > 0 && index < group.size()){
                
                int[] count= group.get(index++);
                
                for(int mineral=0;mineral<3;mineral++){
                    answer+= count[mineral]*fatigue[pick][mineral];
                }
                
                picks[pick]--;
            }
        }
        
        return answer;
    }
        
}