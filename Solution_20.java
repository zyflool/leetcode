/*
20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:
输入: "()"
输出: true

示例 2:
输入: "()[]{}"
输出: true

示例 3:
输入: "(]"
输出: false

示例 4:
输入: "([)]"
输出: false

示例 5:
输入: "{[]}"
输出: true
*/
import java.util.ArrayList;
class Solution {
    public static void main ( String[] args ) {
        String s = "{[]}";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        ArrayList<Character> stack = new ArrayList<>();
        int l = s.length();
        if ( l == 0 ) return true;
        for (int i = 0 ; i < l ; i++ ) {
            char c =s.charAt(i);
            if ( c == '(' || c == '{' || c == '[' ) {
                stack.add( c );
            }
            else {
                if ( stack.size() == 0)
                    return false;
                switch (c) {
                    case '}': {
                        if ( stack.get(stack.size() - 1) == '{' ) {
                            stack.remove(stack.size()-1);
                        }
                        else {
                            return false;
                        }
                        break;
                    }
                    case ']': {
                        if ( stack.get(stack.size() - 1) == '[' ) {
                            stack.remove(stack.size()-1);
                        }
                        else {
                            return false;
                        }
                        break;
                    }
                    case ')': {
                        if ( stack.get(stack.size() - 1) == '(' ) {
                            stack.remove(stack.size()-1);
                        }
                        else {
                            return false;
                        }
                        break;
                    }
                }
            }
        }
        if ( stack.size() == 0 )
            return true;
        else
            return false;
    }
}