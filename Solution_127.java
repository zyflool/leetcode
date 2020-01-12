/*
127. 单词接龙
给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。

说明:
如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。

示例 1:
输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
输出: 5
解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。

示例 2:
输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
输出: 0

解释: endWord "cog" 不在字典中，所以无法进行转换。
*/

import sun.plugin2.message.CustomSecurityManagerAckMessage;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        String beginword = "hot";
        String endword = "dog";
        List<String> wordlist = new ArrayList<>();
        wordlist.add("hot");
        wordlist.add("dog");
        wordlist.add("cog");
        wordlist.add("pot");
        wordlist.add("dot");
        Solution solution = new Solution();
        System.out.println(solution.ladderLength(beginword, endword, wordlist));
    }
/*
    int minl = Integer.MAX_VALUE;

    public void bfs(String beginWord, String endWord, List<String> wordList, HashMap<String, ArrayList<String>> map,
                    HashMap<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        boolean isFound = false;
        int depth = 0;
        Set<String> dict = new HashSet<>(wordList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int j = 0; j < size; j++) {
                String temp = queue.poll();
                // 一次性得到所有的下一个的节点
                ArrayList<String> neighbors = getNeighbors(temp, dict);
                map.put(temp, neighbors);
                for (String neighbor : neighbors) {
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, depth);
                        if (neighbor.equals(endWord)) {
                            isFound = true;
                        }
                        queue.offer(neighbor);
                    }

                }
            }
            if (isFound) {
                break;
            }
        }
    }

    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char chs[] = node.toCharArray();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch)
                    continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

    private void findLaddersHelper(String beginWord, String endWord, HashMap<String, ArrayList<String>> map,
                                   HashMap<String, Integer> distance, ArrayList<String> temp) {
        if (beginWord.equals(endWord)) {
            minl = Math.min(temp.size(), minl)
            return;
        }*/
        // 得到所有的下一个的节点
        /*
        "a"
        "c"
        ["a","b","c"]*/
        //之所以是 map.getOrDefault 而不是 get，就是上边的情况 get 会出错
/*
        ArrayList<String> neighbors = map.getOrDefault(beginWord, new ArrayList<String>());
        for (String neighbor : neighbors) {
            //判断层数是否符合
            if (distance.get(beginWord) + 1 == distance.get(neighbor)) {
                temp.add(neighbor);
                findLaddersHelper(neighbor, endWord, map, distance, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if ( !wordList.contains(endWord) ) {
            return 0;
        } else { // 利用 BFS 得到所有的邻居节点,以及每个节点的所在层数
            HashMap<String, Integer> distance = new HashMap<>();
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            bfs(beginWord, endWord, wordList, map, distance);

            ArrayList<String> temp = new ArrayList<String>();
            // temp 用来保存当前的路径
            temp.add(beginWord);
            findLaddersHelper(beginWord, endWord, map, distance, temp);
            return minl == Integer.MAX_VALUE ? 0 : minl;
        }
    }*/
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        if (beginWord.equals(endWord)) return 2;

        // 可能遇见的节点集
        Set<String> meets = new HashSet<>(wordList); // O(n)

        Set<String> beginSet = new HashSet<>(Collections.singleton(beginWord));
        Set<String> endSet = new HashSet<>(Collections.singleton(endWord));

        return this._search(1, beginSet, endSet, meets);
    }

    private int _search(int level, Set<String> beginSet, Set<String> endSet, Set<String> meets) {
        // terminator
        if (beginSet.size() == 0 || endSet.size() == 0) return 0;

        // process
        meets.removeAll(beginSet);
        level++;
        Set<String> nextLevelSet = new HashSet<>();
        // iter every begin word
        for (String beginWord : beginSet) {
            char[] chars = beginWord.toCharArray();
            // iter for every char
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                // replace every letter
                for (char ch = 'a'; ch < 'z'; ch++) {
                    chars[i] = ch;
                    String newWord = String.valueOf(chars);
                    if (!meets.contains(newWord)) continue;
                    if (endSet.contains(newWord)) return level;
                    nextLevelSet.add(newWord);
                }
                // reverse
                chars[i] = temp;
            }
        }

        // drill down
        // always from less to more
        if (nextLevelSet.size() <= endSet.size()) {
            beginSet = nextLevelSet;
        } else {
            beginSet = endSet;
            endSet = nextLevelSet;
        }

        return this._search(level, beginSet, endSet, meets);
    }
}