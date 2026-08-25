import java.util.*;


class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,ArrayList<Integer>> m =new HashMap<>();
        
        HashMap<String,Integer> ms =new HashMap<>();
        
        HashMap<Integer,String> k =new HashMap<>();
        
        ArrayList<Integer> a;
        
        int index = 0;
        for(String s : genres){
            a = m.getOrDefault(s,new ArrayList<Integer>());
            ms.put(s,ms.getOrDefault(s,0)+plays[index]);
            a.add(index);
            m.put(s,a);
            index++;
        }
        
        
        for(String l : genres){
            k.put(ms.get(l),l);
        }
        
        ArrayList<Integer> findkey = new ArrayList<Integer>(ms.values());
        
        findkey.sort(Comparator.reverseOrder());
        
        ArrayList<Integer> solution = new ArrayList<>();
        
        for(int res : findkey){
            String tk = k.get(res);
            ArrayList<Integer> ta = m.get(tk);
            
            int[] temparray = new int[ta.size()];
            
            for(int i=0; i<ta.size(); i++){
                temparray[i] = ta.get(i);
            }
            
            insertsort(temparray,plays,ta.size());
            
            if(ta.size() > 2){
                for(int i=0; i<2;i++){
                    solution.add(temparray[i]);
                }
            }else{
                for(int i=0; i<ta.size();i++){
                    solution.add(temparray[i]);
                }
            }
            
        }
        
        int[] answer = new int[solution.size()];

        for(int i=0;i<solution.size();i++){
            answer[i] = solution.get(i);   
        }
        
        return answer;
    }
    
    public static void insertsort(int[] ta, int[] plays,int n){
            
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(plays[ta[i]] < plays[ta[j]]){
                    int a = ta[i];
                    ta[i] = ta[j];
                    ta[j] = a;
                }
            }
        }
    }
}