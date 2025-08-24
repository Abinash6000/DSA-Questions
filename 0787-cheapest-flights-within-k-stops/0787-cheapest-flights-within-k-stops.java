class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = Integer.MAX_VALUE/2; // divide by 2 to just keep elements in range
        int[] dist = new int[n];

        Arrays.fill(dist, INF);
        dist[src] = 0;

        for(int i = 0; i<=k; i++) {
            int[] temp = dist.clone();

            for(int[] f : flights) {
                int u = f[0], v = f[1], w = f[2];

                if(dist[u] + w < temp[v]) {
                    temp[v] = dist[u] + w;
                }
            }

            dist = temp;
        }

        return dist[dst] != INF ? dist[dst] : -1;
    }
}