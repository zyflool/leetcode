/*
22. 括号生成
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
例如，给出 n = 3，生成结果为：
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
                                                                                         ""
                                                   (                                                             (==)
                                               /             \
                             /                                          \
                        ((                                                              ()
                     /      \                                                          /  \
                  /            \                                                      /    \
               /                  \                                                  /      \
            /                        \                                              /        \
         /                              \                                          /          \
      (((                                 (()                                    ()(           (==)
    /     \                          /           \                            /      \
   /       \                      /                 \                     /                 \
(<=3       ((()                (()(                  (())             ()((                   ()()
          /    \              /    \                 /   \            /  \                   /  \
         /      \            /      \               /     \          /    \                 /    \
     (<=3       ((())      (<=3    (()()          (())(    (==)   (<=3   ()(()           ()()(   (==)
               /     \            /     \         /   \                  /   \           /   \
              /       \          /       \       /     \                /     \         /     \
           (<=3       ((()))   (<=3   (()())   (<=3   (())()        (<=3      ()(())  (<=3   ()()()

*/
import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main ( String[] args ) {
        int n = 3;
        List<String> ans = generateParenthesis(n);
        int l = ans.size();
        for ( int i = 0 ; i < l ; i++ )
            System.out.println(ans.get(i));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if ( n == 0 )
            return ans;
        work(ans,"", n, n);
        return ans;
    }

    public static void work (List<String> ans, String s, int left, int right) {
        if ( left == right && left == 0 ) {
            ans.add(s);
            return;
        } else if ( left == right ) {
            work(ans, s+"(", left-1, right);
        } else if ( left == 0 ) {
            work(ans, s+")", left, right-1);
        } else {
            work(ans, s+"(", left-1, right);
            work(ans, s+")", left,right-1);
        }
    }
}