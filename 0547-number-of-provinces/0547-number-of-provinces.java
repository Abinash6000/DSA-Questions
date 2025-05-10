class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] vis = new int[n];
        int noOfProv = 0;

        for(int i = 0; i<n; i++) {
            if(vis[i] == 0) {
                noOfProv++;
                dfs(vis, isConnected, i, n);
            }
        }

        return noOfProv;
    }

    private void dfs(int[] vis, int[][] isConnected, int i, int n) {
        vis[i] = 1;
        for(int j = 0; j<n; j++) {
            int conn = isConnected[i][j];

            if(conn == 1 && vis[j] == 0) {
                dfs(vis, isConnected, j, n);
            }
        }
    }
}