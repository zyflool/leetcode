/*
17. 电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

 1    2   3
!@#  abc def
 4    5   6
ghi  jkl mno
  7   8   9
pqrs tuv wxyz

示例:
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main ( String[] args ) {
        String digits = "23";
        System.out.println(letterCombinations(digits).toString());
    }

    private static Map<Character,Character[]> map = new HashMap<>();
    private static List<String> ans = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        if ( digits.length() == 0 )
            return ans;
        map.put('2',new Character[]{'a','b','c'});
        map.put('3',new Character[]{'d','e','f'});
        map.put('4',new Character[]{'g','h','i'});
        map.put('5',new Character[]{'j','k','l'});
        map.put('6',new Character[]{'m','n','o'});
        map.put('7',new Character[]{'p','q','r','s'});
        map.put('8',new Character[]{'t','u','v'});
        map.put('9',new Character[]{'w','x','y','z'});
        adds(new StringBuffer(),digits);
        return ans;
    }

    public static void adds ( StringBuffer exist, String remain){
        if ( remain.isEmpty() ) {
            ans.add(exist.toString());
            //exist.setLength(0);
            exist.deleteCharAt(exist.length()-1);
            return;
        }
        Character[] characters = map.get(remain.charAt(0));
        int n = characters.length;
        for (int i = 0 ; i < n ; i++ ) {
            adds(exist.append(characters[i]), remain.substring(1));
            if ( i == n - 1 && exist.length() != 0)
                exist.deleteCharAt(exist.length()-1);
        }
    }
}