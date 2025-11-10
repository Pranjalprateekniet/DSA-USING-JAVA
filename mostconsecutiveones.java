public class mostconsecutiveones {
    public int consecutive(int[] arr) {
        int c = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                c++;
                if (c > max) {
                    max = c;
                }
            } else {
                if (c > max) {
                    max = c;
                }
                c = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1 };
        mostconsecutiveones mco = new mostconsecutiveones();
        int res = mco.consecutive(arr);
        System.out.println(res + " ");
    }
}
