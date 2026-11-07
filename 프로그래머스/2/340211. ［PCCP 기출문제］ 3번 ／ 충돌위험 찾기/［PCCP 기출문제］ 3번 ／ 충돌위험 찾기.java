import java.util.*;
import java.io.*;
import java.lang.*;


class Solution {
    public int solution(int[][] points, int[][] routes) {
        
    HashMap<Integer, HashMap<Integer, Integer>> m = new HashMap<>();            
        
        for(int i=0;i<routes.length;i++){
            int time = 0;
            int zeror = points[routes[i][0]-1][0];
            int zeroc = points[routes[i][0]-1][1];
            
            record(m, time, zeror, zeroc);
            
            for(int j=0;j<routes[i].length-1;j++) {
                
                int startr = points[routes[i][j]-1][0];
                int startc = points[routes[i][j]-1][1];
                
                int targetr = points[routes[i][j+1]-1][0];
                int targetc = points[routes[i][j+1]-1][1];
                
                int diffr = targetr - startr;
                int diffc = targetc - startc;
                
                //r좌표 넣기
                int dr = (diffr > 0) ? 1 : -1;
                
                while(startr!=targetr){
                    startr+=dr;
                    time++;
                    record(m,time,startr,startc);
                }
                    
                //c좌표 넣기
                int dc = (diffc > 0) ? 1 : -1;
                
                while(startc!=targetc){
                    startc+=dc;
                    time++;
                    record(m,time,startr,startc);
                }
                
            }
        }
        
        int answer = 0;
        // 모든 시간의 좌표별 로봇 수 확인
        for (HashMap<Integer, Integer> positions : m.values()) {
            for (int count : positions.values()) {
                if (count >= 2) {
                    answer++;
                }
            }
        }

        return answer;
    }
        
    public static void record(HashMap<Integer, HashMap<Integer, Integer>> m,int time, int startr,int startc){
        
        int recordnum = startr*101+startc;
        
        if(m.get(time)==null){
            m.put(time,new HashMap<Integer, Integer>());
        }
        
        HashMap<Integer, Integer> position = m.get(time);
        
        position.put(recordnum,position.getOrDefault(recordnum,0)+1);
    }
}