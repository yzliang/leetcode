public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null || num.length < 2) return;
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] >= num[i + 1]) continue;
            for (int j = num.length - 1; j > i; j--) {
                if (num[j] <= num[i]) continue;
                swap(num, i, j);
                break;
            }
            int l = i + 1, r = num.length - 1;
            while (l < r) swap(num, l++, r--);
            return;
        }
        for (int i = 0; i < num.length / 2; i++) {
            swap(num, i, num.length - 1 - i);
        }
    }

    void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
