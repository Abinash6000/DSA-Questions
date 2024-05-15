class Solution {
    public int[] replaceElements(int[] arr) {
        int currGreat = -1;
        for(int i = arr.length-1; i>=0; i--) {
            int currEle = arr[i];
            arr[i] = currGreat;
            if(currEle > currGreat) currGreat = currEle;
        }

        return arr;
    }
}