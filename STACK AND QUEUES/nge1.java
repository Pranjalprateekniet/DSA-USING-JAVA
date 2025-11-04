import java.util.Stack;

class nextGreaterelement {
    public int[] nextgreater(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }
            if (st.isEmpty())
                res[i] = -1;
            else {
                res[i] = st.peek();
            }
            st.push(nums[i]);
        }
        return res;
    }
}

public class nge1 {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 2, 10 };
        nextGreaterelement ng = new nextGreaterelement();
        int[] ans = ng.nextgreater(nums);
        for (int x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
