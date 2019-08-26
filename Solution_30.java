import java.util.*;

/*
30. 串联所有单词的子串
给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

示例 1：
输入：
  s = "barfoothefoobarman",
  words = ["foo","bar"]
输出：[0,9]
解释：
从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。

示例 2：
输入：
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
输出：[]
*/
class Solution {

    public static void main ( String[] args ) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word","good","best","good"};
        System.out.println(findSubstring(s,words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (words.length == 0 || s.length() < words.length * words[0].length()) //如果没有子串或者字符串长度小于子串长度总和
            return list;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) //记录每个子串的个数
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        int listLen = words.length;
        int wordLen = words[0].length();

        for (int i = 0; i < wordLen; i++) { //在单个子串的长度内开始循环
            for (int j = i; j <= s.length() - wordLen * listLen; j += wordLen) { //每次移动一个子串的长度
                Map<String, Integer> map2 = new HashMap<>();
                for (int k = listLen - 1; k >= 0; k--) { //从后往前查找子串
                    String temp = s.substring(j + k * wordLen, j + (k + 1) * wordLen);//截取子串
                    int val = map2.getOrDefault(temp, 0) + 1;//记录子串出现个数
                    if (val > map.getOrDefault(temp, 0)) {//如果当前子串出现的次数多余给定的次数
                        j += k * wordLen;//向后移动一个子串的长度
                        break;
                    }
                    if (k == 0) {//如果已经查找到起点，没有多出的子串，记录答案
                        list.add(j);
                    } else {//否则记录已有的子串继续循环
                        map2.put(temp, val);
                    }
                }
            }
        }
        return list;
    }
}