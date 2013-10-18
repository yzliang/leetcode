public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> ans = new ArrayList<String>();
        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(0, i);
            if (!check(s1)) continue;
            for (int j = i + 1; j < s.length(); j++) {
                String s2 = s.substring(i, j);
                if (!check(s2)) continue;
                for (int k = j + 1; k < s.length(); k++) {
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k);
                    if (!check(s3) || !check(s4)) continue;
                    ans.add(s1 + '.' + s2 + '.' + s3 + '.' + s4);
                }
            }
        }
        return ans;
    }

    private boolean check(String s) {
        if (s.isEmpty()) return false;
        // Leading zeros!!
        if (s.charAt(0) == '0' && s.length() > 1) return false;
        if (s.length() > 3) return false;
        return Integer.parseInt(s) <= 255;
    }
}
