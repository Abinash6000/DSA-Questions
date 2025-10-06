class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length, res = 0;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int[][] vis = new int[n][n];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(grid[0][0], 0, 0));
        vis[0][0] = 1;

        while(true) {
            Node node = pq.poll();
            res = Math.max(res, node.t);

            if(node.x == n-1 && node.y == n-1) return res;

            for(int[] dir : dirs) {
                int newX = node.x + dir[0], newY = node.y + dir[1];

                if(newX != n && newY != n 
                && newX != -1 && newY != -1 && vis[newX][newY] != 1) {
                    pq.offer(new Node(grid[newX][newY], newX, newY));
                    vis[newX][newY] = 1;
                }
            }
        }
    }

    class Node implements Comparable<Node> {
        int t, x, y;
        Node(int t, int x, int y) {
            this.t = t;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return this.t - o.t;
        }
    }
}