public class Solution {
    public boolean search(int[] A, int target) {
        for (int i : A) if (i == target) return true;
        return false;
    }
}
