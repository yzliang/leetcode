public class Solution {
    public String minWindow(String S, String T) {
        int numChars = Character.MAX_VALUE - Character.MIN_VALUE + 1;
        int[] profileT = new int[numChars];
        for (int i = 0; i < T.length(); i++)
            profileT[T.charAt(i) - Character.MIN_VALUE]++;
        // First substring that covers T.
        int[] profileSub = new int[numChars];
        int numCover = 0;
        int head = 0, tail = 0;
        while (tail < S.length() && numCover < T.length()) {
            int charIndex = S.charAt(tail) - Character.MIN_VALUE;
            if (profileSub[charIndex] + 1 <= profileT[charIndex]) {
                numCover++;
            }
            profileSub[charIndex]++;
            tail++;
        }
        if (numCover < T.length()) return "";
        String ans = S.substring(head, tail);
        while (true) {
            // Remove the head char.
            int charIndex = S.charAt(head++) - Character.MIN_VALUE;
            profileSub[charIndex]--;
            // Slide the tail if necessary.
            while (tail < S.length() &&
                    profileSub[charIndex] < profileT[charIndex])
                profileSub[S.charAt(tail++) - Character.MIN_VALUE]++;
            if (profileSub[charIndex] < profileT[charIndex]) break;
            if (tail - head < ans.length())
                ans = S.substring(head, tail);
        }
        return ans;
    }
}
