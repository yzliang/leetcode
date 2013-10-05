public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int ans = num[0] + num[1] + num[2];
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length - 1; j++) {
                int num3 = target - num[i] - num[j];
                int l = j + 1, r = num.length - 1;
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (num[mid + 1] <= num3) {
                        l = mid + 1;
                    } else if (num[mid] >= num3) {
                        r = mid;
                    } else {
                        if (num3 - num[mid] <= num[mid + 1] - num3)
                            l = r = mid;
                        else
                            l = r = mid + 1;
                    }
                }
                if (Math.abs(num[l] - num3) < Math.abs(target - ans))
                    ans = num[i] + num[j] + num[l];
            }
        }
        return ans;
    }
}
