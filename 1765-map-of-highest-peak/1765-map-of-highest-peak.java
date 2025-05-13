class Solution {
    public int[][] highestPeak(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        int[][] vis = new int[m][n];

        // initializing our Queue, Vis, Res
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(mat[i][j] == 1) {
                    q.add(new int[]{i, j, 0}); // i, j, dist
                    vis[i][j] = 1;
                    res[i][j] = 0;
                }
            }
        }

        // Do BFS
        while(!q.isEmpty()) {
            int i = q.peek()[0], j = q.peek()[1], dist = q.remove()[2];

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, 1, -1};

            for (int z = 0; z<4; z++) {
                int newR = i + dx[z];
                int newC = j + dy[z];

                if(newR > -1 && newR < m &&
                newC > -1 && newC < n &&
                vis[newR][newC] != 1) {
                    vis[newR][newC] = 1;
                    res[newR][newC] = dist+1;
                    q.add(new int[]{newR, newC, dist+1});
                }
            }
        }

        return res;
    }
}