/*
 * 输⼊⼀个字符串，删除所有元⾳字⺟（a, e, i, o, u）
 */
import java.util.HashSet;
import java.util.Set;

public static String removeCharacters(String sentence, Set<Character> vowels) {
    String result = "";
    for (int i = 0; i < sentence.length(); i++) {
        Character item = sentence.charAt(i);
        if (!vowels.contains(item)) {
            result += item;
        }
    }
    return result;
}

 public static void main(String[] args) {
    Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
    removeCharacters("hello world", vowels);
}
