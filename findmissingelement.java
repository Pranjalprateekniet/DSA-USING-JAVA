import java.util.Arrays;

public class findmissingelement {
    /*
     * public int missing(int[] arr) {
     * Arrays.sort(arr);
     * int temp = 0;
     * for (int i = 0; i < arr.length; i++) {
     * if (temp != arr[i])
     * return temp;
     * temp++;
     * }
     * return 0;
     * 
     * }
     */
    // this is the better approach and now i will be doing the optimal approach
    public int missing(int[] arr) {
        int n = arr.length;
        n = (n * (n + 1)) / 2;
        int s2 = 0;
        for (int i = 0; i < arr.length; i++) {
            s2 = s2 + arr[i];
        }
        int res = n - s2;
        return res;

    }

    public static void main(String[] args) {
        int[] arr = { 0, 3, 1, 6, 4, 2 };
        findmissingelement fms = new findmissingelement();
        int res = fms.missing(arr);
        if (res == 0) {
            System.out.println("no element is missing");
        } else {
            System.out.println("the missing element is : " + res);
        }
    }

}