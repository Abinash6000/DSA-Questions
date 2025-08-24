class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] f : flights) adj.get(f[0]).add(new int[]{f[1], f[2]});

        int[][] dist = new int[n][k+2]; 
        for (int[] d : dist) Arrays.fill(d, (int)1e9);
        dist[src][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{src, 0, 0}); // node, cost, stops

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], cost = cur[1], stops = cur[2];
            if (node == dst) return cost;
            if (stops > k) continue;

            for (int[] e : adj.get(node)) {
                int nei = e[0], price = e[1];
                if (cost + price < dist[nei][stops+1]) {
                    dist[nei][stops+1] = cost + price;
                    pq.add(new int[]{nei, cost+price, stops+1});
                }
            }
        }
        return -1;
    }
}
