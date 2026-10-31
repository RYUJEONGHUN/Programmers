import java.util.*;
import java.io.*;

class Node {
    int to;
    int cost;
    
    public Node(int to,int cost){
        this.to = to;
        this.cost = cost;
    }
}

class State {
    int currentstate;
    int distance;
    
    public State(int currentstate,int distance){
        this.currentstate = currentstate;
        this.distance = distance;
    }
    
    public int getdistance(){
        return distance;
    }
}

class Solution {
    public int solution(int N, int[][] road, int K) {
        int[] dist = new int[N+1];
        
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        dist[1] = 0;
            
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<Node>());
        }
        
        int roadl = road.length;
        
        for(int i=0;i<roadl;i++){
            int a = road[i][0];
            int b = road[i][1];
            int cost = road[i][2];
            
            graph.get(a).add(new Node(b,cost));
            graph.get(b).add(new Node(a,cost));
        }
        
        PriorityQueue<State> pq = new PriorityQueue<State>(Comparator.comparing(State::getdistance));
        
        
        pq.add(new State(1,0));
        
        while(!pq.isEmpty()){
            State now = pq.poll();
            
            if(dist[now.currentstate] < now.distance){
                continue;
            }
            
            for(Node a : graph.get(now.currentstate)){
                int newdistance = dist[now.currentstate] + a.cost;
                
                if(newdistance < dist[a.to]){
                    dist[a.to] = newdistance;
                    pq.add(new State(a.to,newdistance));
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