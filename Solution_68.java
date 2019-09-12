/*
68. 文本左右对齐
给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
文本的最后一行应为左对齐，且单词之间不插入额外的空格。

说明:
单词是指由非空格字符组成的字符序列。
每个单词的长度大于 0，小于等于 maxWidth。
输入单词数组 words 至少包含一个单词。

示例:
输入:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
输出:
[
   "This    is    an",
   "example  of text",
   "justification.  "
    justification.
]

示例 2:
输入:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
输出:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
     因为最后一行应为左对齐，而不是左右两端对齐。
     第二行同样为左对齐，这是因为这行只包含一个单词。

示例 3:
输入:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
输出:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        Solution solution = new Solution();
        System.out.println(solution.fullJustify(words, maxWidth));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<String> answer = new ArrayList<>();
        if ( n == 1 ) {
            int l = words[0].length();
            for ( int i = 0 ; i < maxWidth-l; i++ )
                words[0] = words[0]+" ";
            answer.add(words[0]);
            return answer;
        } else {
            int[] lengths = new int[n];
            for ( int i = 0 ; i < n ; i++ )
                lengths[i] = words[i].length();
            int i = 0;
            while ( i < n ) {
                StringBuffer unit = new StringBuffer();
                int start = i;
                int l = 0;
                while (true) {
                    if ( i >= n )
                        break;
                    l += ( lengths[i] + 1 );
                    if ( l > maxWidth && l - maxWidth > 1) {
                         l = l - lengths[i] - 2;
                         i--;
                         break;
                    } else if ( l > maxWidth ) {
                        l = l - 1;
                        break;
                    } else {
                        i++;
                    }
                }
                int end = i;
                if ( i == n ) {
                    for ( int j = start ; j <= i ; j++ ) {
                        if ( j != i )
                            unit.append(words[j] + " ");
                    }
                    while ( unit.length() < maxWidth )
                        unit.append(" ");
                    answer.add(unit.toString());
                    break;
                } else if ( i ==  start) {
                    unit.append(words[start]);
                    while ( unit.length() < maxWidth )
                        unit.append(" ");
                    answer.add(unit.toString());
                } else {
                    int len = 0;
                    for ( int j = start ; j <= end ; j++ )
                        len += words[j].length();
                    int empty = maxWidth - len;
                    int num = end - start;
                    if ( empty % num == 0 ) {
                        int t = empty / num;
                        for ( int j = start ; j <= end ; j++ ) {
                            unit.append(words[j]);
                            if ( j != end ) {
                                for (int k = 0; k < t; k++)
                                    unit.append(" ");
                            }
                        }
                    } else {
                        int t = empty / num;
                        int extra = num - ( ( t + 1 ) * num - empty );
                        for ( int  j = start ; j <= end ; j++ ) {
                            unit.append(words[j]);
                            if ( j - start < extra ) {
                                for ( int k = 0 ; k <= t ; k++ )
                                    unit.append(" ");
                            } else if ( j != end ) {
                                for ( int k = 0 ; k < t ; k++ )
                                    unit.append(" ");
                            }
                        }
                    }
                    answer.add(unit.toString());
                }
                i++;
            }
            return answer;
        }
    }
}