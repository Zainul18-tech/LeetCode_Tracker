// Last updated: 09/07/2026, 10:37:36
import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        HashMap<Character, String> pToS = new HashMap<>();
        HashMap<String, Character> sToP = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            String word = words[i];

            if (pToS.containsKey(p)) {
                if (!pToS.get(p).equals(word))
                  return false;
            } else if (sToP.containsKey(word)) {
                if (sToP.get(word) != p)
                  return false;
            } else {
                pToS.put(p, word);
                sToP.put(word, p);
            }
        }
        return true;
    }
}