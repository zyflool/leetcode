/*
93. 复原IP地址
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

示例:
输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        String s = "25525511135";
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses(s));
    }

    private List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if ( s.length() < 4 ) return ans;
        else if ( s.length() == 4 ) {
            StringBuffer res = new StringBuffer();
            for ( int i = 0 ; i < 4 ; i++ ) {
                if (i != 3) {
                    res.append(s.charAt(i));
                    res.append(".");
                } else res.append(s.charAt(i));
            }
            ans.add(res.toString());
            return ans;
        }else {
            solve(0,new ArrayList<>(),s);
            return ans;
        }
    }

    private void solve(int start, List<String> unit, String s) {
        if ( unit.size() == 3 ) {
            if ( s.length() - start <= 3 && s.length() - start > 0 ) {
                if (  (s.charAt(start) != '0' && Integer.parseInt(s.substring(start)) <= 255 ) ||( s.charAt(start)=='0'&& start+1 == s.length())  ) {
                    StringBuffer answer = new StringBuffer();
                    for ( int i = 0 ; i < 3 ; i++ ) {
                        answer.append(unit.get(i));
                        answer.append('.');
                    }
                    answer.append(s.substring(start));
                    ans.add(answer.toString());
                }
            }
            unit.remove(2);
            return;
        }
        if ( start < s.length() && s.charAt(start) == '0' ) {
            unit.add(s.charAt(start)+"");
            solve(start+1, unit, s);
        } else {
            StringBuffer temp = new StringBuffer();
            for (int i = 0; i < 3 && i + start < s.length(); i++) {
                if (Integer.parseInt(s.substring(start,start+i+1)) <= 255) {
                    unit.add(s.substring(start, start+i+1));
                    solve(start + i + 1, unit, s);
                } else break;
            }
        }
        if ( !unit.isEmpty() )
            unit.remove(unit.size()-1);
    }
}