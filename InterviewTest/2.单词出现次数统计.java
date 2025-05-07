/*
单词出现次数统计
• 原题还原：
◦ 给定⼀个字符串 sentence 和⼀个⽬标单词 word ，统计 word 在 sentence 中出现的
次数（不区分⼤⼩写）。
◦ 注意：
▪ 单词和句⼦仅包含英⽂字⺟，⽆空格或特殊符号。
▪ 统计时需考虑重叠情况（例如 "aaa" 中 "aa" 出现 2 次）。
• 难度：Easy（仅需字符串匹配基础，但需处理⼤⼩写和重叠情况）。
 */
public static int countWordOccurrences(String sentence, String word) {
    if (sentence == null || sentence.length() <= 0 || word == null || word.length() <= 0) {
        return 0;
    }
    int count = 0;
    for (int i = 0; i <= sentence.length() - word.length(); i++) {
        if (sentence.substring(i, i + word.length()).equalsIgnoreCase(word)) {
            count++;
        }
    }
    return count;
}

public static void main(String[] args) {
    countWordOccurrences("aaa", "aa");
}