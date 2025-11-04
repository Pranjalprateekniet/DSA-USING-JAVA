import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] nextSmalllerElement(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() > arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                ans[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }
}

public class nse {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 4 };
        Solution sol = new Solution();
        int[] ans = sol.nextSmalllerElement(arr);
        System.out.print("The next Smaller elements are: ");
        for (int val : ans) {
            System.out.print(val + " ");
        }

    }
}
