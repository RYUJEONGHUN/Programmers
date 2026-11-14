import java.util.*;
import java.io.*;
import java.lang.*;

class Answer{
    int value;
    int index;
    
    public Answer(int value,int index){
        this.value = value;
        this.index = index;
    }
}

class Point{
    int[] temp;
    boolean check = true;
    
    public Point(int[] temp){
        this.temp = temp;
    }
}

class Solution {
    static ArrayList<Point> arr = new ArrayList<Point>();
    static ArrayList<int[]> lastarr =  new ArrayList<int[]>();
    public int solution(int n, int[][] q, int[] ans) {
        
        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
        
        List<Answer> al = new ArrayList<Answer>();
        
        int an = ans.length;
        
        for(int i=0;i<an;i++){
            al.add(new Answer(ans[i],i));
        }
        
        al.sort((p1,p2)->{
            return (p2.value-p1.value);
        });
        
        dfs(q[al.get(0).index],new int[5],0,al.get(0).value,0,n);
        System.out.println(al.get(0).index);
        System.out.println(arr.size());
        
        for(int i=0;i<an;i++){
            int avalue = al.get(i).value;
            int aindex = al.get(i).index;
            
            int[] aq = q[aindex];
            
            for(Point cand : arr){
                if(cand.check){
                    int sum = 0;

                    for(int j=0;j<5;j++){
                        if(contains(cand.temp,aq[j])){
                            sum+=1;
                        };
                    }
                    
                    //System.out.println("끝 값: "+ sum);
                    if(sum != avalue){
                        cand.check = false;
                    }
                }
                
               
            }
        }
 
        int answer = 0;
        for(Point cand : arr){
            if(cand.check){
                if(!duplicatecheck(cand)){
                    lastarr.add(cand.temp);
                    answer++;  
                }
            }
        }
        
        return answer;
    }
    public static boolean duplicatecheck(Point p){
        
        int[] arr = p.temp;
        
        for(int[] s : lastarr){
            int tsum = 0;
            for(int i=0;i<5;i++){
                if(contains(s,arr[i])){
                    tsum++;
                }
            }
            if(tsum == 5){
                return true;
            }
        }
        
        return false;

    }
    
    public static void dfs(int[] q,int[] temp,int level,int limit,int k,int n){
        if(level == limit){
            ldfs(q,temp,level,5,1,n);
            return;
        }
        
        for(int i=k;i<5;i++){
            temp[level] = q[i];
            dfs(q,temp,level+1,limit,i+1,n);
            temp[level] = -1;
        }
    }
    
    public static void ldfs(int[] q,int[] temp,int level,int limit,int k,int n){
        if(level == limit){
            
            arr.add(new Point(temp.clone()));
            return;
        }
        
        for(int i=k;i<=n;i++){
            if(!contains(temp,i)){
                temp[level] = i;
                ldfs(q,temp,level+1,limit,i+1,n);
                temp[level] = -1;
            }
        }
    }
    
    public static boolean contains(int[] temp,int value){
        
        for(int i=0;i<temp.length;i++){
            if(temp[i]==value){
                return true;
            }
        }
        return false;
        
    }
}