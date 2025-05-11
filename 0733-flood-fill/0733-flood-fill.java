class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color == image[sr][sc]) return image;
        int currColor = image[sr][sc];
        image[sr][sc] = color;

        int[] rows = {sr, sr, sr-1, sr+1};
        int[] cols = {sc-1, sc+1, sc, sc};

        for(int i = 0; i<4 ; i++) {
            if(rows[i] != -1 
            && cols[i] != -1 
            && rows[i] != image.length 
            && cols[i] != image[0].length 
            && image[rows[i]][cols[i]] == currColor) {

                floodFill(image, rows[i], cols[i], color);
            }
        }
 
        return image;
    }
}