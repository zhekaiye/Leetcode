//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() <= 0) {
            return true;
        }
        Stack<String> stack = new Stack<String>();
        int i = 0;
        for (; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if ('(' == curChar || '[' == curChar || '{' == curChar) {
                stack.push("" + curChar);
            } else if (')' == curChar || ']' == curChar || '}' == curChar) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (')' == curChar && "(".equals(stack.peek())) {
                    stack.pop();
                } else if (']' == curChar && "[".equals(stack.peek())) {
                    stack.pop();
                } else if ('}' == curChar && "{".equals(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return i >= s.length() && stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
