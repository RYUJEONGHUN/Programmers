import java.util.*;

class Solution {
    public int solution(int[][] routes) {

        Arrays.sort(routes,
            (a, b) -> Integer.compare(a[1], b[1]));

        int camera = -30001;
        int answer = 0;

        for (int[] route : routes) {
            if (route[0] > camera) {
                camera = route[1];
                answer++;
            }
        }

        return answer;
    }
}