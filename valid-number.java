public class Solution {
    public boolean isNumber(String s) {
        String base = "[+\\-]?((\\d+)|(\\d+\\.\\d*)|(\\d*\\.\\d+))";
        String exp = "([eE][+\\-]?\\d+)?";
        return s.trim().matches(base + exp);
    }
}
