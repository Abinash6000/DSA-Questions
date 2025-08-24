class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<List<Integer>>> adjList = new ArrayList<>(); 
        for(int i = 0; i<n; i++) 
            adjList.add(new ArrayList<>());
        for(int i = 0; i<flights.length; i++) 
            adjList.get(flights[i][0]).add(Arrays.asList(flights[i][1], flights[i][2]));
            // storing dst, cost

        // Distance array to store the updated distances from the source. 
        int[] dist = new int[n]; 
        for(int i = 0;i<n;i++) {
            dist[i] = (int)(1e9); 
        }
        dist[src] = 0; 

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]); 
        pq.add(new int[]{src, 0, 0}); // node, dist(sort), k

        while(!pq.isEmpty()) {
            int[] node = pq.remove();

            if(node[2] > k) continue;

            for(List<Integer> adj : adjList.get(node[0])) {
                if (node[1] + adj.get(1) < dist[adj.get(0)]) {
                    dist[adj.get(0)] = node[1] + adj.get(1);
                    pq.add(new int[]{adj.get(0), node[1]+adj.get(1), node[2]+1});
                }
            }
        }

        if(dist[dst] == (int)(1e9)) return -1; 
        return dist[dst]; 
    }
}