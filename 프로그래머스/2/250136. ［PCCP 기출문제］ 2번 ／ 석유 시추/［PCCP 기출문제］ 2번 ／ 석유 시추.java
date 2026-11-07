import java.util.*;
import java.lang.*;
import java.io.*;


class Point{
    int r;
    int c;
    
    public Point(int r,int c){
        this.r = r;
        this.c = c;
    }
}

class Land{
    int version;
    int count;
    
    public Land(int version,int count){
        this.version = version;
        this.count = count;
    }
}

class Solution {
    static int[][] visited;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static Land[][] larr;
    static int version = 0;
    
    public int solution(int[][] land) {
        
        int n = land.length;
        int m = land[0].length;
            
        larr = new Land[n][m];
        visited = new int[n][m];
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] == 0 && land[i][j] == 1){
                    Queue<Point> q = new LinkedList<Point>();
                    q.add(new Point(i,j));
                    visited[i][j] = 1;
                    bfs(land,q,n,m,i,j);
                }
            }
        }
        
        int answer = 0;
        
        for(int i=0;i<m;i++){
            int ctotal = 0;
            HashSet<Integer> s = new HashSet<Integer>();
            
            for(int j=0;j<n;j++){
                if(larr[j][i] !=null && !s.contains(larr[j][i].version)){
                    s.add(larr[j][i].version);
                    ctotal += larr[j][i].count;
                }
            }
            answer = Math.max(answer,ctotal);
        }
        
        return answer;
    }
    
    public static void bfs(int[][] land,Queue<Point> q,int n,int m,int i,int j){
        
        ArrayList<Point> plist = new ArrayList<Point>();
        plist.add(new Point(i,j));
        int count = 1;
        
        while(!q.isEmpty()){
            Point c = q.poll();
            
            for(int a=0; a<4; a++){
                int tr = dr[a] + c.r; 
                int tc = dc[a] + c.c;
                
                if(tr>=0 && tr<=n-1 && tc>=0 && tc<=m-1 && visited[tr][tc]==0 && land[tr][tc]==1){
                    q.add(new Point(tr,tc));
                    plist.add(new Point(tr,tc));
                    visited[tr][tc] = 1;
                    count++;
                }
            }
            
        }
        
            
        for(Point p : plist){
            larr[p.r][p.c] =  new Land(version,count);
        }
        
        version++;
    }
    
}