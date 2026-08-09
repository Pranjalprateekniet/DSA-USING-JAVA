class movezerotoend {
    public void moveZeroes(int[] arr) {
        int n = arr.length;
        int k;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                k = arr[i];
                arr[i] = arr[i + 1];
                arr[n - 1] = k;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 66, 3, 0, 5, 4, 0, 0, 4, 6 };
        movezerotoend mze = new movezerotoend();
        mze.moveZeroes(arr);
    }
}