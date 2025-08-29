class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]); // parent, node, w
        pq.add(new int[]{0, k, 0});

        List<List<int[]>> adjList = new ArrayList<>();
        for(int i = 0; i<=n; i++) adjList.add(new ArrayList<>());

        for(int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            adjList.get(u).add(new int[]{v, w});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        while(!pq.isEmpty()) {
            int[] node = pq.remove();
            int par = node[0], u = node[1], w = node[2];

            for(int[] adjNode : adjList.get(u)) {
                int v = adjNode[0], adjW = adjNode[1];
                if(dist[v] > w+adjW) {
                    dist[v] = w+adjW;
                    pq.add(new int[]{u, v, dist[v]});
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for(int i = 1; i<=n; i++) res = Math.max(res, dist[i]);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}