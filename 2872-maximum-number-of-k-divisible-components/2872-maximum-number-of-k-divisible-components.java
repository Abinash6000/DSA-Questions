class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        int[] res = new int[1];
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i<n; i++)
            adjList.add(new ArrayList<>());

        for(int[] edge : edges) {
            int n1 = edge[0], n2 = edge[1];
            adjList.get(n1).add(n2);
            adjList.get(n2).add(n1);
        }

        helper(res, adjList, values, k, 0, -1);
        return res[0];
    }

    private int helper(int[] res, List<List<Integer>> adjList, int[] values, int k, int curr, int parent) {

        long total = values[curr];
        for(int child : adjList.get(curr)) {
            if(child == parent)
                continue;

            total += helper(res, adjList, values, k, child, curr);
        }

        if(total % k == 0) {
            res[0]++;
            return 0;
        }

        return (int)total%k;
    }
}