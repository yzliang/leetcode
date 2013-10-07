public class Solution {
    public String countAndSay(int n) {
        if (n < 1) return "";
        StringBuilder source = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            StringBuilder target = new StringBuilder();
            int pos = 0;
            while (pos < source.length()) {
                int next = pos + 1;
                while (next < source.length() && source.charAt(next) ==
                        source.charAt(pos))
                    next++;
                target.append(next - pos);
                target.append(source.charAt(pos));
                pos = next;
            }
            source = target;
        }
        return source.toString();
    }

    public static void main(String args[]) {
        System.out.println(new Solution().countAndSay(
                    Integer.parseInt(args[0])));
    }
}
