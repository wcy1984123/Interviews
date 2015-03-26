package ShortenURL;

/**
 * Project: Interviews
 * Package: ShortenURL
 * Date: 22/Mar/2015
 * Time: 00:29
 * System Time: 12:29 AM
 */

/*
    Shorten url.
    From : https://github.com/delight-im/ShortURL (Apache License 2.0)
 */

/**
 * ShortURL: Bijective conversion between natural numbers (IDs) and short strings
 *
 * ShortURL.encode() takes an ID and turns it into a short string
 * ShortURL.decode() takes a short string and turns it into an ID
 *
 * Features:
 * + large alphabet (51 chars) and thus very short resulting strings
 * + proof against offensive words (removed 'a', 'e', 'i', 'o' and 'u')
 * + unambiguous (removed 'I', 'l', '1', 'O' and '0')
 *
 * Example output:
 * 123456789 <=> pgK8p
 *
 * Source: https://github.com/delight-im/ShortURL (Apache License 2.0)
 */

public class Solution {

    public static final String ALPHABET = "23456789bcdfghjkmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ-_";
    public static final int BASE = ALPHABET.length();

    public static String encode(int num) {
        StringBuilder str = new StringBuilder();
        while (num > 0) {
            str.insert(0, ALPHABET.charAt(num % BASE));
            num = num / BASE;
        }
        return str.toString();
    }

    public static int decode(String str) {
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            num = num * BASE + ALPHABET.indexOf(str.charAt(i));
        }
        return num;
    }

    public static void main(String[] args) {
        int num = 9976;
        String res = Solution.encode(num);
        System.out.println(res);
        System.out.println("-------------------");
        int code = Solution.decode(res);
        System.out.println(code);

        int i = 0;
        int j = i++;
        System.out.println(j);

        i = 0;
        j = ++i;
        System.out.println(j);
    }

}
