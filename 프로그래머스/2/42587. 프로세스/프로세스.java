import java.util.*;

class Process{
    int priority;
    int location;
    
    public Process(int priority,int location){
        this.priority = priority;
        this.location = location;
    }
}


class Solution {
    public int solution(int[] priorities, int location) {
        
        Queue<Process> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int l = priorities.length;
        
        for(int i=0; i<l; i++){
            q.add(new Process(priorities[i],i));
            pq.add(priorities[i]);
        }
        
        int count = 0;
        
        while(!pq.isEmpty()){
            
            if(q.peek().priority == pq.peek()){
                Process a = q.poll();
                pq.poll();
                count++;
                if(a.location == location){
                    System.out.print(count);
                    return count;
                }
            }else{
                Process p = q.poll();
                q.add(p);
            }
        }
        return count;
        
        
    }
}