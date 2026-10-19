import java.util.*;
import java.io.*;

class Maze{
	int minimum;
	int need;
	
	public Maze(int minimum,int need) {
		this.minimum=minimum;
		this.need=need;
	}
}


class Solution{
	static ArrayList<Maze> marr = new ArrayList<Maze>();
	static ArrayList<int[]> seq = new ArrayList<int[]>();
	
	public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        
        for(int i=0;i<n;i++) {
        	marr.add(new Maze(dungeons[i][0],dungeons[i][1]));
        }
        
        dfs(0,n,new int[n],new int[n]);
        
        
        
        return getMax(k);
    }
	
	public static void dfs(int level,int n,int[] temp,int[] visited) {
		
		if(level == n) {
			seq.add(temp.clone());
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(visited[i]==0) {
				visited[i]=1;
				temp[level]=i;
				dfs(level+1,n,temp,visited);
				visited[i]=0;
			}
			
		}
	}
	
	public static int getMax(int k){
		
		int max = Integer.MIN_VALUE;
		
		for(int[] s : seq) {
			int start = k;
			int n = s.length;
			int count=0;
			
			for(int i=0;i<n;i++) {
				
				Maze tm = marr.get(s[i]);
				
				if(start>=tm.minimum) {
					count++;
					start-=tm.need;
				}else {
					break;
				}
				
			}
			
			max = Math.max(count, max);
		}
		
		return max;
	}
}