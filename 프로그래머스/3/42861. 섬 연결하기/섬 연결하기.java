import java.util.*;
import java.lang.*;

class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        
        parent = new int[n];
        
        Arrays.sort(costs,Comparator.comparing(a->a[2]));
        
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        
       
        
        int answer = 0;
        
        for(int[] cost : costs){
            int a = cost[0];
            int b = cost[1];
            
            int w = cost[2];
            
            if(find(a)==find(b)){
                continue;
            }
            
            union(a,b);
            answer+=w;
        }
        
        return answer;
    }
    
    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        
        return parent[x] = find(parent[x]);
    } 
    
    public static void union(int x,int y){
        int rootA = find(x);
        int rootB = find(y);
        
        if(rootA != rootB){
            parent[rootB] = rootA;
        }
    }
}