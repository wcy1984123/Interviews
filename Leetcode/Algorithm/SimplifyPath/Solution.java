package SimplifyPath;

import java.util.Stack;

/**
 * Project: Interviews
 * Package: SimplifyPath
 * Date: 20/Mar/2015
 * Time: 11:22
 * System Time: 11:22 AM
 */

/*
    Given an absolute path for a file (Unix-style), simplify it.

    For example,
    path = "/home/", => "/home"
    path = "/a/./b/../../c/", => "/c"
    click to show corner cases.

    Corner Cases:
    Did you consider the case where path = "/../"?
    In this case, you should return "/".
    Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
    In this case, you should ignore redundant slashes and return "/home/foo".
 */

/*
    用栈来做，先把输入字符串以'/'为分隔符分来，如果遇到'.'或者空输入什么都不做。
    如果遇到'..'就弹栈。然后每从栈里退出一个元素就用'/'连接起来，注意顺序。
 */

public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return null;

        String[] paths = path.split("/");

        String res = "";
        // at least there are one string in the paths array
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].equals(".") || paths[i].length() == 0) {
                continue;
            } else if (paths[i].equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(paths[i]);
            }
        }

        if (stack.isEmpty()) return res + "/";

        while(!stack.isEmpty()) res = "/" + stack.pop() + res;

        return res;
    }
}