/**i is the start point, if the hashtable doesn't contains
current character, continue to count up.
else there are two case, #1 is this character is appear before
the start point, like example: cbacbfae, when the second a is current
character, the map will have the character already, but it is before 
current start point second b; #2 case is the start point should be changed 
right after the previous appearance of current character. like example:
bacdebf when the sencond b is encounter. The key point here is how to avoid
calculating the length with considering character before the start point
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}