import java.util.*;
import java.io.*;
import java.lang.*;

class Point{
    int i;
    int j;
    
    public Point(int i,int j){
        this.i=i;
        this.j=j;
    }
}

class Solution {
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    
    public int solution(String[] storage, String[] requests) {
            
        int n = storage.length;
        
        int m = storage[0].length();
        
        char[][] arr = new char[n][m];
        int[][] visited = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = storage[i].charAt(j);
            }
        }
        
        for(int kl=0;kl<requests.length;kl++){
            String s = requests[kl];
            
            int sn = s.length();
                            
            if(sn==1){
                ArrayList<Point> plist = new ArrayList<Point>();
                ArrayList<Point> realplist = new ArrayList<Point>();
                
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        if(arr[i][j] == s.charAt(0) && visited[i][j]==0){
                            plist.add(new Point(i,j));
                        }
                    }
                }
                
                
                for(Point p : plist){
                    Queue<Point> q = new LinkedList<Point>();
                    q.add(p);
                    boolean check = false;
                    boolean[][] seen = new boolean[n][m];
                    seen[p.i][p.j] = true;
                    
                    while(!q.isEmpty()){
                        Point tp = q.poll();
                        
                        for(int k=0;k<4;k++){
                            int cr = tp.i+dr[k];
                            int cc = tp.j+dc[k];
                            
                            if(cr < 0 || cr >= n || cc < 0 || cc >=m){
                                check = true;
                                break;
                            }
                            
                            if(visited[cr][cc]==1 && !seen[cr][cc]){
                                q.add(new Point(cr,cc));
                                seen[cr][cc]=true;
                            }
                        }
                       
                        if(check){
                            break;
                        }
                    } 
                    if(check){
                        realplist.add(p);
                    }
                }
                
                for(Point p : realplist){
                    visited[p.i][p.j]=1;
                }
                
            }else{
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        if(arr[i][j] == s.charAt(0) && visited[i][j]==0){
                            visited[i][j]=1;
                        }
                    }
                }
            }
        
        }
        
        int answer = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0){
                    answer++;
                 }
             }                               
        }
        
        return answer;
    }
}