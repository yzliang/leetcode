public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 0; i < rowIndex; i++) {
            int prev = row.get(0);
            for (int j = 1; j < row.size(); j++) {
                int temp = row.get(j);
                row.set(j, prev + temp);
                prev = temp;
            }
            row.add(1);
        }
        return row;
    }
}
