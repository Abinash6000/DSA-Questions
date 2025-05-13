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
            int[] node = q.remove();
            int i = node[0], j = node[1], dist = node[2];

            int[] d = {0, 1, 0, -1, 0};

            for (int z = 0; z<4; z++) {
                int newR = i + d[z];
                int newC = j + d[z+1];

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