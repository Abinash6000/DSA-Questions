class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        Arrays.sort(intervals, (i1,i2) -> Integer.compare(i1[0],i2[0]));
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        ArrayList<Integer> fstEle = new ArrayList<>();
        fstEle.add(intervals[0][0]);
        fstEle.add(intervals[0][1]);

        res.add(fstEle);

        for(int i = 1; i<intervals.length; i++) {
            ArrayList<Integer> lastEle = res.get(res.size()-1);
            if(intervals[i][0] <= lastEle.get(1)) {
                int upBd = lastEle.remove(1);
                lastEle.add(Math.max(intervals[i][1], upBd));
            } else {
                ArrayList<Integer> newEle = new ArrayList<>();
                newEle.add(intervals[i][0]);
                newEle.add(intervals[i][1]);
                res.add(newEle);
            }
        }

        int finalRes[][] = new int[res.size()][2];
        for(int i = 0; i<res.size(); i++) {
            int interval[] = new int[2];
            interval[0] = res.get(i).get(0);
            interval[1] = res.get(i).get(1);
            finalRes[i] = interval;
        }

        return finalRes;
    }
}