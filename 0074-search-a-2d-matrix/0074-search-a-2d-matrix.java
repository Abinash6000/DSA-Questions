class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int cols = matrix[0].length, rows = matrix.length;
        int s = 0, e = cols*rows-1;

        while(s < e) {
            int mid = s+(e-s)/2;
            if(matrix[mid/cols][mid%cols] < target) {
                s = mid+1;
            } else {
                e = mid;
            }
        }

        return matrix[e/cols][e%cols] == target ? true : false;
    }
}