package com.zero.leetcode;

import java.util.Stack;

/**
 * @Auther: wdd
 * @Date: 2020-05-05 17:47
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 有效的括号 {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            }else {
                if (c == ')') {
                    Character pop = stack.pop();
                    if (pop != '(') {
                        return false;
                    }
                }else if (c == '}') {
                    Character pop = stack.pop();
                    if (pop != '{') {
                        return false;
                    }
                }else if (c == ']') {
                    Character pop = stack.pop();
                    if (pop != '[') {
                        return false;
                    }
                }else {
                    stack.push(c);
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

}
