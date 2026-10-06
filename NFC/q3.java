import java.util.*;
public class q3 {
    static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static int calculateMaxCost(int[][] grid, int k, Map<String, 
Integer> memo) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] visited = new int[m][n];
        int maxCost = -1;
        dfs(grid, 0, 0, 0, k, maxCost, visited, memo);
        return maxCost;
    }

    private static void dfs(int[][] grid, int x, int y, int cost, int 
turns, int maxCost, int[][] visited, Map<String, Integer> memo) {
        String key = x + "," + y + "," + turns;
        if (memo.containsKey(key)) {
            maxCost = Math.max(maxCost, memo.get(key));
            return;
        }

        if (x == grid.length - 1 && y == grid[0].length - 1) {
            maxCost = Math.max(maxCost, cost);
            memo.put(key, cost);
            return;
        }
        visited[x][y] = turns + 1;
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && visited[newX][newY] <= turns) {
                int newCost = cost + grid[newX][newY];
                int newTurns = turns + 1;
                dfs(grid, newX, newY, newCost, newTurns, maxCost, visited, memo);
            }
        }
        visited[x][y] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int grid[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter number of turns allowed:");
        int k = sc.nextInt();
        Map<String, Integer> memo = new HashMap<>();
        int ans = calculateMaxCost(grid, k, memo);
        System.out.println("max cost = " + ans);
        sc.close();
    }
}
 