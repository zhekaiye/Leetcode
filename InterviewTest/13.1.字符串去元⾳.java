/*
 * 去除字符串中的元⾳字⺟。
 * 输⼊：字符串；
 * 输出：处理后的字符串；
 * 难度：Easy（字符串操作）
 */
class Solution {
    public String removeVowels(String sentence) {
        String result = "";
        for (int i = 0; i < sentence.length(); i++) {
            Character item = sentence.charAt(i);
            if (!isVowel(item)) {
                result += item;
            }
        }
        return result;
    }
    private boolean isVowel(Character item) {
        return item == 'a' || item == 'e' || item == 'i' || item == 'o' || item == 'u'
                || item == 'A' || item == 'E' || item == 'I' || item == 'O' || item == 'U';
    }
}
