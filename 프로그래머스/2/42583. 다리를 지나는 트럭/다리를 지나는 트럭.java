import java.util.*;


class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer,Integer> m =new HashMap<>();
        
        int sum = 0;
        
        int truck_index = 0;
        
        int truck_length = truck_weights.length;
    
        q.add(truck_weights[truck_index]);
        arr.add(truck_index);
        m.put(truck_index,1);
        sum += truck_weights[truck_index];
        truck_index++;
        
        int t = 1;
        
        while(!q.isEmpty()){
            t++;
            
            int n = arr.size();
            
            for(int i=0; i<n; i++){
                m.put(arr.get(i),m.get(arr.get(i))+1);
            }
            
            if(m.get(arr.get(0)) > bridge_length){
                sum -= q.poll();
                arr.remove(0);
            }
            
            if(truck_index < truck_length) {
                if(sum + truck_weights[truck_index] <= weight){
                    q.add(truck_weights[truck_index]);
                    arr.add(truck_index);
                    m.put(truck_index,1);
                    sum += truck_weights[truck_index];
                    truck_index++;
                }
            }
        }
        return t;
    }
}