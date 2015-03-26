package RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: Interviews
 * Package: RestoreIPAddresses
 * Date: 20/Mar/2015
 * Time: 00:45
 * System Time: 12:45 AM
 */

/*
    Given a string containing only digits, restore it by returning all possible valid IP address combinations.

    For example:
    Given "25525511135",

    return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */

/*
    几点注意的地方：
    1. 在验证字符串是否是数字的时候，要注意0的情况，001，010，03都是非法的。所以，如果第一位取出来是0，那么我们就判断字符串是否是"0"，不是的情况都是非法的
    2. 取字符串的时候，注意位数不够的问题，不仅<4, 而且<s.length()
    3. 注意substring的范围
    4. 字符串转换成数字 Integer.parseInt();
    5. 别忘了IP 地址里面的 "."
    6. 到第4个Part的时候我们就可以整体验证剩下的所有字符串（因为第4个Part最后一定要取到结尾才是正确的字符串）
 */

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) return new ArrayList<String>();

        List<String> res = new ArrayList<String>();

        restoreIpAddresses(s, 0, 0, "", res);

        return res;
    }

    public void restoreIpAddresses(String s, int pos, int count, String partialres, List<String> res) {
        if (count == 3) {
            int length = s.length() - pos;
            if (length > 0 && length < 4) {
                String temp = s.substring(pos, s.length());
                if (isValid(temp)) {
                    res.add(new String(partialres + "." + temp));
                }
            }
            return;
        }

        count++;
        for (int i = pos; i < s.length() && i < pos + 3; i++) {
            String temp = s.substring(pos, i + 1);
            if (isValid(temp)) {
                String ss = count == 1 ? s.substring(pos, i + 1) : partialres + "." + s.substring(pos, i + 1);
                restoreIpAddresses(s, i + 1, count, ss, res);
            }
        }

        return;
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return false;
        if (s.charAt(0) == '0') return s.equals("0");
        int value = Integer.parseInt(s);
        return value >= 0 && value <= 255;
    }
}
