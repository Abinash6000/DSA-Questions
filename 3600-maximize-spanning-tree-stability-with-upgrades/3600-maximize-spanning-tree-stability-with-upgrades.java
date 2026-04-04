class Solution {
    class DSU {
        int[] parent;
        int components;

        public DSU(int n) {
            parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
            components = n;
        }

        public int find(int i) {
            if(parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }

        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if(rootI != rootJ) {
                parent[rootI] = rootJ;
                components--;
                return true;
            }

            return false;
        }


    }

    public int maxStability(int n, int[][] edges, int k) {
        // 1. Initial impossibility checks
        DSU initialDsu = new DSU(n);
        int minMust = Integer.MAX_VALUE;

        for(int[] e : edges) {
            if(e[3] == 1) {
                minMust = Math.min(minMust, e[2]);
                if(!initialDsu.union(e[0], e[1]))
                    return -1; // mandatory edges form a cycle
            }
        }

        DSU fullDsu = new DSU(n);
        for(int[] e : edges) 
            fullDsu.union(e[0], e[1]);

        if(fullDsu.components > 1) 
            return -1;

        // 2. Binary Search for the maximum stability
        int low = 1;
        int high = minMust == Integer.MAX_VALUE ? 200000 : minMust;
        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(canAchieve(n, edges, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else 
                high = mid - 1;
        }

        return ans;
    }

    private boolean canAchieve(int n, int [][] edges, int k, int target) {
        DSU dsu = new DSU(n);
        int upgradesUsed = 0;

        // 1: add all mandatory edges (cost = 0)
        for(int[] e : edges) {
            if(e[3] == 1) {
                dsu.union(e[0], e[1]);
            }
        }

        for(int[] e : edges) {
            if(e[3] == 0 && e[2] >= target)
                dsu.union(e[0], e[1]);
        }

        // 2: add all optional edges that don't need an upgrade (cost = 0)
        for(int[] e : edges) {
            if(e[3] == 0 && e[2] >= target) 
                dsu.union(e[0], e[1]);
        }

        for(int[] e : edges) {
            if(e[3] == 0 && e[2] < target && e[2]*2 >= target)
                if(dsu.union(e[0], e[1]))
                    upgradesUsed++;
        }

        return dsu.components == 1 && upgradesUsed <= k;
    }
}