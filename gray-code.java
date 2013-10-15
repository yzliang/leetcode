public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> codes = new ArrayList<Integer>();
        codes.add(0);
        for (int i = 0; i < n; i++) {
            int size = codes.size();
            for (int j = size - 1; j >= 0; j--)
                codes.add(codes.get(j) | (1 << i));
        }
        return codes;
    }
}
