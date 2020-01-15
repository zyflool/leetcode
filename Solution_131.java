/*
131. 分割回文串
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
返回 s 所有可能的分割方案。

示例:
输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        String s = "a";
        Solution solution = new Solution();
        System.out.println(solution.partition(s));
    }

    boolean[][] isPali;
    String str;
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }
        isPali = calcuPali(s);
        str = s;
        dfs(res , new ArrayList<>() , 0);
        return res;
    }

    public boolean[][] calcuPali(String s){
        int n = s.length();
        boolean[][] isPali = new boolean[n][n];
        char[] ch = s.toCharArray();
        int i, j;
        for(int mid = 0; mid < n; mid ++){
            i = mid;
            j = mid;
            while(i >= 0 && j < n && ch[i] == ch[j]){
                isPali[i][j] = true;
                i --;
                j ++;
            }
            i = mid;
            j = mid + 1;
            while(i >= 0 && j < n && ch[i] == ch[j]){
                isPali[i][j] = true;
                i --;
                j ++;
            }
        }
        return isPali;
    }

    public void dfs(List<List<String>> res , List<String> list , int index){
        if(index == str.length()){
            res.add(new ArrayList<>(list));
            return ;
        }
        for(int i = index + 1; i <= str.length(); i ++){
            if(isPali[index][i - 1]){
                list.add(str.substring(index , i));
                dfs(res , list , i);
                list.remove(list.size() - 1);
            }
        }
    }
}