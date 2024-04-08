class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allRows = new ArrayList<>(); // This we need to return
        for (int i = 0; i<numRows; i++) { // To create rows
            List<Integer> currRow = new ArrayList<>(); // This stores current row
            currRow.add(0,1); // This adds 1 to the first index of current row
            if (allRows.size()!=0) { // This is done to add [1] as first element to allRows
                List<Integer> prevRow = allRows.get(i-1); // Getting the previous row from allRows
                for (int j = 1; j<i; j++) { // we will get the values from previous row and add them to new row.
                    int num1 = prevRow.get(j-1);
                    int num2 = prevRow.get(j);
                    currRow.add(j,num1+num2);
                }
                currRow.add(i,1); // at last we will add 1 to the current row.
            }
            allRows.add(currRow); // Adding current row to All rows. Thus, creating pascal's triangle.
        }
        return allRows; // return pascal's triangle.
    }
}