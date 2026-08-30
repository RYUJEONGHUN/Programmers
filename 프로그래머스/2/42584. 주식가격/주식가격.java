import java.util.*;

class Node{
    int index;
    int value;
    int standard;
    public Node(int index,int value,int standard){
        this.index = index;
        this.value = value;
        this.standard = standard;
    }
}

class Solution {
    public int[] solution(int[] prices) {
        
        int l = prices.length;
        int[] answer = new int[l];

        ArrayList<Node> arr = new ArrayList<>();
        
        for(int i=0; i<l;i++){
            arr.add(new Node(i,prices[i],0));
        }
        
        Deque<Node> stack = new ArrayDeque<>();
        
        stack.push(arr.get(0));
        
        for(int i=1; i<l;i++){
            
            //넣으려는 값
            Node n = arr.get(i);
            
            //스택 맨앞값
            Node up = stack.peek();
            
            if(n.value < up.value){
                int cnt = 0;
                while(n.value < up.value){
                    Node a = stack.pop();
                    cnt++;
                    int ti = a.index;
                    answer[ti] = cnt;
                    cnt += a.standard;
                    if(stack.isEmpty()){
                        break;
                    }else{
                        up = stack.peek();
                    }
                }
                n.standard = cnt;
                stack.push(n);
            }else{
               stack.push(n); 
            }
        }
    
        int cnt = 0;
        while(!stack.isEmpty()){
            Node a = stack.pop();
            int ti = a.index;
            answer[ti] = cnt;
            cnt++;
            cnt += a.standard;
        }
        
        return answer;
    }
}