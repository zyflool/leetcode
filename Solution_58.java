class Solution {
    public int lengthOfLastWord(String s) {
        int l = s.length();
        if ( l == 0 )
            return l;
        while ( s.charAt(l-1) == ' ' ) {
            l--;
            if ( l == 0 )
                return l;
        }
        int last = s.lastIndexOf(' ' , l-1);
        if (last < 0)
            return l;
        else
            return l-last-1;
    }
}