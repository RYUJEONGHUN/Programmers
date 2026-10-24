import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        ArrayList<HashSet<Integer>> dp = new ArrayList<>();
        
        for(int i=0 ; i<=8; i++){
            dp.add(new HashSet<Integer>());
        }
        boolean check = false;
        int result = -1;
        
        dp.get(1).add(N);
        if(dp.get(1).contains(number)){
            return 1;
        }
        int sum = N*10+N;
        dp.get(2).add(sum);
        dp.get(2).add(N+N);
        dp.get(2).add(N-N);
        dp.get(2).add(N*N);
        dp.get(2).add(N/N);
        if(dp.get(2).contains(number)){
            return 2;
        }
        for(int i=3;i<=8;i++){
            sum=sum*10+N;
            dp.get(i).add(sum);
            
            for(int j=1;j<=i-1;j++){
                HashSet<Integer> a = dp.get(j); 
                HashSet<Integer> b = dp.get(i-j);
                
                for(Integer ta : a){
                    for(Integer tb : b){
                        dp.get(i).add(ta+tb);
                        dp.get(i).add(ta-tb);
                        dp.get(i).add(ta*tb);
                        if(tb>0){
                            dp.get(i).add(ta/tb);
                        }
                    }
                }  
            }
            if(dp.get(i).contains(number)){
                    check=true;
                    result=i;
                    break;
            }
        }
       return result;
    }
}