import java.util.*;
import java.io.*;
import java.lang.*;


class Point{
    int r;
    int c;
    int level;
    
    public Point(int r,int c,int level){
        this.r = r;
        this.c = c;
        this.level = level;
    }
}


class Solution {
    static int[][] visited;
    static char[][] arr;
    
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        
        visited = new int[n][m];
        arr = new char[n][m];
        
        Point r = new Point(-1,-1,0);
        Point g = new Point(-1,-1,0);
        
        for(int i=0;i<n;i++){
            
            String temp = board[i];
            
            for(int j=0;j<m;j++){
                arr[i][j] = temp.charAt(j);
                
                if(arr[i][j] == 'R'){
                    r.r = i;
                    r.c = j;
                }
                
                if(arr[i][j] == 'G'){
                    g.r = i;
                    g.c = j;
                }
            }
        }
       
        
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(r.r,r.c,0));
        visited[r.r][r.c] = 1;
        
        //boolean check = false;
        int answer = -1;
        
        while(!q.isEmpty()){
            Point cp = q.poll();
            
            if(cp.r == g.r && cp.c == g.c ){
                //check = true;
                answer = cp.level;
                break;
            }
            
            for(int index=0;index<4;index++){
                Point mp = move(n,m,cp.r,cp.c,index);
            
                if(visited[mp.r][mp.c]==0){
                    q.add(new Point(mp.r,mp.c,cp.level+1));
                    visited[mp.r][mp.c]=1;
                }
            }
            
        }

        return answer;
    }
    
    public static Point move(int n,int m,int i,int j,int index){
        
        while(true){
            int ti = i + dr[index];
            int tj = j + dc[index];
            
            if(ti >= 0 && ti<=n-1 && tj >= 0 && tj<=m-1 && arr[ti][tj]!='D'){
                i = ti;
                j = tj;
                
            }else{
                break;
            }
        }
        return new Point(i,j,-1);
    }
}