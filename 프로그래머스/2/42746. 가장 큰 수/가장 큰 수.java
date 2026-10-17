import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public String solution(int[] numbers) {
    	
    	String ts="";
    	ArrayList<String> arr = new ArrayList<String>();
    	
    	for(int i=0;i<numbers.length;i++) {
    		arr.add(Integer.toString(numbers[i]));
    	}
    	arr.sort((a, b) -> (b + a).compareTo(a + b));
    	
    	for(String s : arr) {
    		ts+=s;
    	}
        if(ts.startsWith("0")){
            ts="0";
        }
    	
    	return ts;
    }
    

}

