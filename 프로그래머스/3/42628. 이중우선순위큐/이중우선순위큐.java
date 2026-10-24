import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minq = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        
        for(int i=0; i<operations.length;i++){
            String[] str = operations[i].split(" ");
            
            String c = str[0];
            
            int v = Integer.parseInt(str[1]);
            
            if(c.equals("I")){
                map.put(v,1);
                minq.add(v);
                maxq.add(v);
            }else if(c.equals("D")){
                if(v==-1){
                    while(!minq.isEmpty()){
                      int k = minq.poll();
                      if(map.get(k)>0){
                           map.put(k,map.get(k)-1); 
                           break;
                      }else{
                          continue;
                      }
                    }
                }else if(v==1){
                   while(!maxq.isEmpty()){
                      int z = maxq.poll();
                      if(map.get(z)>0){
                           map.put(z,map.get(z)-1); 
                           break;
                      }else{
                          continue;
                      }
                    }
                }
            }         
        }
        
        int max = 0;
        int min = 0;
        
        while(!minq.isEmpty()){           
           int k = minq.poll();
            if(map.get(k)>0){
                min= k;
                break;
            }else{
              continue;
            }         
        }
        
        while(!maxq.isEmpty()){           
           int k = maxq.poll();
            if(map.get(k)>0){
                max= k;
                break;
            }else{
              continue;
            }         
        }
        
        int[] answer = {max,min};
        return answer;
    }
}