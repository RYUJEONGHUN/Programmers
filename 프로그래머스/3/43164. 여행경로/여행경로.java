import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {

        // 출발 공항 -> 도착 공항 목록
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (String[] ticket : tickets) {
            map.putIfAbsent(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).offer(ticket[1]);
        }

        Stack<String> stack = new Stack<>();
        LinkedList<String> result = new LinkedList<>();

        stack.push("ICN");

        while (!stack.isEmpty()) {

            String current = stack.peek();

            // 현재 공항에서 사용할 항공권이 남아 있는 경우
            if (map.containsKey(current) &&
                !map.get(current).isEmpty()) {

                String next = map.get(current).poll();
                stack.push(next);

            } else {

                // 더 이상 이동할 곳이 없으면 경로 확정
                result.addFirst(stack.pop());
            }
        }

        return result.toArray(new String[0]);
    }
}