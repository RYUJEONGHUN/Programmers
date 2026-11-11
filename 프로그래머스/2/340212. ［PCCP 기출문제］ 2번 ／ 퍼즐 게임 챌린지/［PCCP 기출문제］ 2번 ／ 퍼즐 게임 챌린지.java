class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        
        int m = 0;
        
        for(int i=0;i<diffs.length;i++){
            m = Math.max(m,diffs[i]);
        }
        
        int left = 1;
        int right = m;
        
        int answer = m;
        
        while(left <= right){
            
            int mid = (left+right) / 2 ;
            
            if(check(diffs,times,limit,mid)){
                answer = mid;
                right = mid-1; 
            }else{
                left = mid+1; 
            }
        }
        
        return answer;
    }
    
    public static boolean check(int[] diffs,int[] times,long limit,int mid){
        
        int n = diffs.length;
        long sum = 0;
        for(int i=0;i<n;i++){
            
            if(mid >= diffs[i]){
                sum += times[i];
            }else{
                sum += (times[i-1]+times[i]) * (diffs[i] - mid) + times[i];
            }
        }
        if(sum <= limit){
            return true;
        }else{
            return false;
        }
    }
}