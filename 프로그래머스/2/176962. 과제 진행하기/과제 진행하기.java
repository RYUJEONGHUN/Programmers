import java.util.*;
import java.io.*;
import java.lang.*;

class Assignment{
    
    String name;
    int start;
    int playtime;
    int h;
    int m;
    
    public Assignment(String name,int start, int playtime,int h,int m){
        this.name = name;
        this.start = start;
        this.playtime = playtime;
        this.h = h;
        this.m = m;
    }
    
    public int getstart(){
        return start;
    }
    
}

class Solution {
    static ArrayList<Assignment> assignlist = new ArrayList<Assignment>();
    
    public String[] solution(String[][] plans) {

        for(int i=0;i<plans.length;i++){
            
            String[] str = plans[i][1].split(":");
            int h = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            
            String name = plans[i][0];
            int start = h*100+m;
            int playtime = Integer.parseInt(plans[i][2]);
            
            assignlist.add(new Assignment(name,start,playtime,h,m));
        }
        
        assignlist.sort(Comparator.comparing(Assignment::getstart));
        
        ArrayList<Assignment> ass = new ArrayList<Assignment>();
        
        Stack<Assignment> st = new Stack<Assignment>();
        
        Assignment currentassignment = assignlist.get(0);
        
        int timeh = currentassignment.h;
        int timem = currentassignment.m;
            
        for(int i=1;i<assignlist.size();i++){
            Assignment nextassignment = assignlist.get(i);
            while(true){
                int cplaytime = currentassignment.playtime;
                
                if(timeh == nextassignment.h && timem == nextassignment.m){
                    if(cplaytime>0){
                        st.push(currentassignment);
                    }else if(cplaytime==0){
                        ass.add(currentassignment);
                    }
                    
                    currentassignment = nextassignment;
                    break;
                }
                
                if(cplaytime == 0){
                    ass.add(currentassignment);
                    
                    if(!st.isEmpty()){
                        currentassignment = st.pop();
                    }
                }
                
                timem++;
                currentassignment.playtime--;
                    
                if(timem==60){
                    timem=0;
                    timeh++;
                }
            }
        }
        
        ass.add(currentassignment);
        while(!st.isEmpty()){
            Assignment a = st.pop();

            ass.add(a);
        }
        
        String[] result = new String[ass.size()];
        
        int count = 0;
        
        for(Assignment a : ass){
            result[count++] = a.name; 
        }
    
        return result;
    }
}