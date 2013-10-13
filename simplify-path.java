public class Solution {
    public String simplifyPath(String path) {
        ArrayList<String> names = new ArrayList<String>();
        int i = 0;
        while (i != path.length()) {
            int j = i + 1;
            while (j < path.length() && path.charAt(j) != '/')
                j++;
            String segment = path.substring(i + 1, j);
            if (segment.equals("") || segment.equals(".")) {
                // Do nothing.
            } else if (segment.equals("..")) {
                if (!names.isEmpty()) names.remove(names.size() - 1);
            } else {
                names.add(segment);
            }
            i = j;
        }
        if (names.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append('/');
            sb.append(name);
        }
        return sb.toString();
    }
}
