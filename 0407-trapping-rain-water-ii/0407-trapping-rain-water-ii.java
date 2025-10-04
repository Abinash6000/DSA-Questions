class Solution {
    class Cell {
        int row, col, height;
        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heights) {
        PriorityQueue<Cell> pq = new PriorityQueue<>((a,b) -> a.height - b.height);

        int m = heights.length, n = heights[0].length;
        boolean[][] vis = new boolean[m][n];

        // Initially add all the border cells
        for(int i = 0; i<m; i++) {
            vis[i][0] = true; vis[i][n-1] = true;

            pq.offer(new Cell(i, 0, heights[i][0]));
            pq.offer(new Cell(i, n-1, heights[i][n-1]));
        }

        for(int i = 0; i<n; i++) {
            vis[0][i] = true; vis[m-1][i] = true;

            pq.offer(new Cell(0, i, heights[0][i]));
            pq.offer(new Cell(m-1, i, heights[m-1][i]));
        }

        // track max height and res
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0, maxH = 0;

        while(!pq.isEmpty()) {
            Cell cell = pq.poll();
            maxH = Math.max(maxH, cell.height);
            res += maxH - cell.height;

            for(int[] dir : dirs) {
                int nr = cell.row + dir[0];
                int nc = cell.col + dir[1];

                if( nr < 0 || nr == m
                 || nc < 0 || nc == n
                 || vis[nr][nc]) 
                    continue;

                pq.offer(new Cell(nr, nc, heights[nr][nc]));
                vis[nr][nc] = true;
            }
        }

        return res;
    }
}