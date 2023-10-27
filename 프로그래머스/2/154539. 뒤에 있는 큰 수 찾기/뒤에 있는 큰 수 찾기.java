import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int length = numbers.length;
        int[] answer = new int[length];
        Stack<Integer> st = new Stack<>();
        for (int i = length - 1; i >= 0; i--) {
            while (!st.isEmpty()) {
                if (st.peek() > numbers[i]) {
                    answer[i] = st.peek();
                    break;
                } else {
                    st.pop();
                }
            }
            if (st.isEmpty()) {
                answer[i] = -1;
            }
            st.push(numbers[i]);
        }
        return answer;
    }
}