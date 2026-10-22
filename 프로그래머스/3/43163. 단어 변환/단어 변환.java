import java.util.*;

class Point{
	String s;
	int count;
	
	public Point(String s,int count) {
		this.s = s;
		this.count = count;
	}
}


class Solution {
	
    public int solution(String begin, String target, String[] words) {
        
    	int n = words.length;
    	
    	int[] visited = new int[n];
    	
    	Queue<Point> q = new LinkedList<Point>();
    	
    	Point firstp = new Point(begin,0);
    	
    	checkList(q,firstp,words,visited);
    	
    	int answer = 0;
    	
    	while(!q.isEmpty()) {
    		Point temp = q.poll();
    		
    		if(temp.s.equals(target)) {
    			answer = temp.count;
    			break;
    		}
    		
    		
    		checkList(q,temp,words,visited);
    		
    		
    	}
    	
        return answer;
    }
    
    public static void checkList(Queue<Point> q,Point temp,String[] words,int[] visited) {
    	
    	String bs = temp.s;
    	int bc = temp.count;
    	
    	for(int i=0;i<words.length;i++) {
    		
    		int count=0;
    		String w = words[i];
    		int n = bs.length();
    		
    		for(int j=0;j<n;j++) {
    			
    			if(bs.charAt(j)!=w.charAt(j)) {
    				count++;
    				
    				if(count>1) {
    					break;
    				}
    			}
    		}
    		
    		if(count==1) {
    			if(visited[i]==0) {
    				visited[i]=1;
    				q.add(new Point(words[i],bc+1));
    			}
    		}
    	}
    }
    
    
}