class Solution {
    public int[] findOrder(int numCourses, int[][] prereq) {
        int[] res = new int[numCourses];
        int[] indeg = new int[numCourses];

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<numCourses; i++) adjList.add(new ArrayList<>());

        for(int[] req : prereq) {
            adjList.get(req[1]).add(req[0]);
            indeg[req[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<numCourses; i++)
            if(indeg[i] == 0)
                q.add(i);

        int count = 0, i = 0;
        while(!q.isEmpty()) {
            int curr = q.remove();
            res[i++] = curr;
            count++;

            for(int adj : adjList.get(curr)) {
                indeg[adj]--;
                if(indeg[adj] == 0)
                    q.add(adj);
            }
        }

        if(count == numCourses) return res;
        else return new int[0];
    }
}