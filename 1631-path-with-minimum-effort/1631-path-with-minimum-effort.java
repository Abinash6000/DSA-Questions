class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]); // node(i,j), effort
        pq.add(new int[]{0,0,0});

        int[][] dist = new int[m][n];
        for(int i = 0; i<m; i++) for(int j = 0; j<n; j++)
            dist[i][j] = Integer.MAX_VALUE;
        dist[0][0] = 0;

        while(!pq.isEmpty()) {
            int[] node = pq.remove();
            int i = node[0], j = node[1];

            int[] x = {0, 1, 0, -1}, y = {1, 0, -1, 0};
            for(int k = 0; k<4; k++) {
                int nx = i+x[k], ny = j+y[k];
                if(nx < 0 || nx == m || ny < 0 || ny == n) continue;

                int newEffort = Math.max(dist[i][j], Math.abs(heights[i][j] - heights[nx][ny]));
                if(newEffort < dist[nx][ny]) {
                    dist[nx][ny] = newEffort;
                    pq.add(new int[]{nx, ny, newEffort});
                }
            }
        }

        return dist[m-1][n-1];
    }
}