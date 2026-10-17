import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {        
        ArrayList<Integer> arr=new ArrayList<Integer>();
    	
        for(int i=0;i<citations.length;i++) {
        	arr.add(citations[i]);
        }
        
        arr.sort(Comparator.reverseOrder());
        
        int start = arr.get(0);
        int result = 0;
        int n = citations.length;
        
        while(true) {
        	int up=0;
        	int down=0;
        	boolean check =false;
        	
        	int h = start;
        	
        	int count=0;
        	for(Integer a: arr) {
        		if(a>start) {
        			count++;
        			up=count;
        			down=n-count;
        			
        			if(up>=h && h>=down) {
        				check=true;
        				break;
        			}
        		}else if(a==start) {
        			count++;
        			up=count;
        			down=n-count;
        			
        			if(up>=h && h>=down) {
        				check=true;
        				break;
        			}
        		}else {
        			continue;
        		}
        	}
        	
        	if(check) {
    			result=h;
    			break;
    		}else {
            	start--;
    		}
         }
        
        return result;
    }
}