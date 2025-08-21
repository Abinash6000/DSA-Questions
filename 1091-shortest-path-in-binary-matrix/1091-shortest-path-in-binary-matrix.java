class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        grid[0][0] = 1; // reuse grid to store distance (start at 1)

        int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
        int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};

        while (!q.isEmpty()) {
            int[] cell = q.remove();
            int x = cell[0], y = cell[1];
            int dist = grid[x][y];

            if (x == n-1 && y == n-1) return dist; // reached target

            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (grid[nx][ny] != 0) continue; // blocked or already visited

                grid[nx][ny] = dist + 1; // mark distance & visited
                q.add(new int[]{nx, ny});
            }
        }

        return -1;
    }
}