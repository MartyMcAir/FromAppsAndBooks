/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_matrixPattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author MartyMcAir
 */
// https://play.google.com/store/apps/details?id=com.freetymekiyan.apas
// Leetcode Algorithm Coding, Java Interview Offline
public class Word {

    Map<Character, String> map = new HashMap<>();
    Set<String> set = new HashSet<>();

    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern.isEmpty()) {
            return str.isEmpty();
        }
        if (map.containsKey(pattern.charAt(0))) {
            String value = map.get(pattern.charAt(0));
            if (str.length() < value.length() || !str.substring(0, value.length()).equals(value)) {
                return false;
            }
            if (wordPatternMatch(pattern.substring(1), str.substring(value.length()))) {
                return true;
            }
        } else {
            for (int i = 1; i <= str.length(); i++) {
                if (set.contains(str.substring(0, i))) {
                    continue;
                }
                map.put(pattern.charAt(0), str.substring(0, i));
                set.add(str.substring(0, i));
                if (wordPatternMatch(pattern.substring(1), str.substring(i))) {
                    return true;
                }
                set.remove(str.substring(0, i));
                map.remove(pattern.charAt(0));
            }
        }
        return false;
    }
}
