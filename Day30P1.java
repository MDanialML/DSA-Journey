import java.util.Map;
import java.util.HashMap;

public class Day30P1 {

    public static int longestSubString(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If character already seen, move left pointer
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, right);

            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "packings";
        System.out.println("Max length: " + longestSubString(s));
    }
}