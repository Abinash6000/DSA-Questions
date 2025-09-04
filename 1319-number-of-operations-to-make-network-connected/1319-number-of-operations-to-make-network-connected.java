class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1; // we don't have enough cables

        DisjointSet ds = new DisjointSet(n);

        // step1: build the graph by union
        for(int[] con : connections) {
            int u = con[0], v = con[1];
            ds.unionBySize(u, v);
        }

        // step2: check for disconnected components in O(1) through ds
        int res = 0;
        int u = 0; // reference node

        for(int v = 1; v<n; v++) {
            int ulp_u = ds.findUPar(u);
            int ulp_v = ds.findUPar(v);
            if(ulp_u == ulp_v) continue;

            res++;
            ds.unionBySize(u, v);
        }

        return res;
    }

    class DisjointSet {
        int[] size, parent;
        DisjointSet(int n) {
            size = new int[n]; parent = new int[n];
            for(int i = 0; i<n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        private int findUPar(int node) {
            if(parent[node] == node) return node;

            int ulp = findUPar(parent[node]);
            parent[node] = ulp; // path compression
            return ulp;
        }

        private void unionBySize(int u, int v) {
            int ulp_u = findUPar(u), ulp_v = findUPar(v);

            if(ulp_u == ulp_v) return;

            if(size[ulp_u] < size[ulp_v]) {
                parent[ulp_u] = ulp_v;
                size[ulp_v] += size[ulp_u];
            } else {
                parent[ulp_v] = ulp_u;
                size[ulp_u] += size[ulp_v];
            }
        }
    }
}