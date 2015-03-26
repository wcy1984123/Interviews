package MinimumWindowSubstring;

/**
 * Project: Interviews
 * Package: MinimumWindowSubstring
 * Date: 20/Mar/2015
 * Time: 11:13
 * System Time: 11:13 AM
 */

/*
    Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

    For example,
    S = "ADOBECODEBANC"
    T = "ABC"
    Minimum window is "BANC".

    Note:
    If there is no such window in S that covers all characters in T, return the emtpy string "".

    If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */

/*
    可以利用两个指针扫描（两个指针分别为start，i），以S = “e b a d b a c c b”（忽略空格），T = “abc”为例：

    0 1 2 3 4 5 6 7 8

    初始化 start = i = 0
    1）i 逐渐往后扫描S直到窗口S[start…i]包含所有T的字符，此时i = 6（字符c的位置）
    2）缩减窗口：此时我们注意到窗口并不是最小的，需要调整 start 来缩减窗口。
        缩减规则为：如果S[start]不在T中 或者 S[start]在T中但是删除后窗口依然可以包含T中的所有字符，那么start = start+1， 直到不满足上述两个缩减规则。
        缩减后i即为窗口的起始位置，此例中从e开始窗口中要依次删掉e、b、a、d，start最后等于4 ，那么得到一个窗口大小为6-4+1 = 3
    3）start = start+1(此时窗口肯定不会包含所有的T中的字符)，跳转到步骤2继续寻找下一个窗口。
        本例中还以找到一个窗口start = 5，i = 8，比上个窗口大，因此最终的最小窗口是S[4…6]
 */

public class Solution {
    public String minWindow(String S, String T) {
        int ASCIILength = 256;
        int[] srcHash = new int[ASCIILength];
        for(int i = 0; i < T.length(); i++){
            srcHash[T.charAt(i)]++;
        }
        int start = 0,i= 0;
        int[] destHash = new int[ASCIILength];
        int found = 0;
        int begin = -1, end = S.length(), minLength = 1 + S.length();
        for(start = i = 0; i < S.length(); i++){
            if(srcHash[S.charAt(i)]!=0){
                destHash[S.charAt(i)]++;
                if(destHash[S.charAt(i)] <= srcHash[S.charAt(i)]) found++;
                if(found == T.length()){
                    //find the first window that satisfied this condition
                    //next step : shrink the window size
                    while(start < i) {
                        if(srcHash[S.charAt(start)] == 0 || (srcHash[S.charAt(start)] != 0 && (--destHash[S.charAt(start)]) >= srcHash[S.charAt(start)])) {
                            start++;
                        }else {
                            break;
                        }
                    }
                    if(i - start + 1< minLength){
                        minLength = i - start + 1;
                        begin = start;
                        end = i;
                    }
                    found--;
                    start++;
                }
            }
        }
        return begin == -1 ? "" : S.substring(begin,end + 1);
    }
}
