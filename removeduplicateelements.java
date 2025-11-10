public class removeduplicateelements {
    public int removeduplicates(int[] arr) {
        int c = 1;
        int size = arr.length;
        for (int i = 1; i <= size - 1; i++) {
            if (arr[i - 1] != arr[i]) {
                arr[c] = arr[i];
                c++;
            }
        }
        int dup = c;
        return dup;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 1, 2, 3, 4, 5, 5, 5, 6 };
        removeduplicateelements rde = new removeduplicateelements();
        int result = rde.removeduplicates(arr);
        System.out.println("Number of unique elements: " + result);

    }
}
