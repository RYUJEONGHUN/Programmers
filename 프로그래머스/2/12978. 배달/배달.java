import java.util.*;
import java.lang.*;

class Node{
    int to;
    int cost;
    
    public Node(int to,int cost){
        this.to = to;
        this.cost = cost;
    }
    
    public int getcost(){
        return cost;
    }
}

class Solution {
    public int solution(int N, int[][] road, int K) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>(
        Comparator.comparing(Node::getcost)
        );
        
        int[] dist = new int[N+1];
        
        Arrays.fill(dist,Integer.MAX_VALUE);

        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<Node>());
        }
        
        for(int i=0;i<road.length;i++){
            int a = road[i][0];
            int b = road[i][1];
            
            int c = road[i][2];
            
            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }
        
        dist[1] = 0;
        pq.add(new Node(1,0));
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(now.cost > dist[now.to]){
                continue;
            }
            
            for(Node next : graph.get(now.to)){
                int newcost = next.cost + dist[now.to];
                
                if(newcost < dist[next.to]){
                    dist[next.to] = newcost;
                    pq.add(new Node(next.to,newcost));
                }
            }
        }
        
        int count = 0;
        for(int i=1;i<=N;i++){
            if(dist[i]<=K){
                count++;
            }
        }

        return count;
    }
}