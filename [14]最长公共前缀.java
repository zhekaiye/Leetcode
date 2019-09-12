//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (result.length() <= 0) {
                return "";
            }
            if (!strs[i].startsWith(result)) {
                result = result.substring(0, result.length() - 1);
                i--;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
