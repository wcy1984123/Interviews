package UniqueBinarySearchTreeI;

/**
 * Project: Interviews
 * Package: UniqueBinarySearchTreeI
 * Date: 20/Mar/2015
 * Time: 00:42
 * System Time: 12:42 AM
 */

/*
    Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

    For example,
    Given n = 3, there are a total of 5 unique BST's.

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
 */

/*
    In “Unique Binary Search Trees”, we are only required to output the number of the trees.
    We know that all nodes in the left subtree are smaller than the root. And all nodes in the right subtree are larger than the root.
    For a integer n, we have n options to be the root. In these options, assuming i is the value that we choose to be the root.
    The value in left subtree are from 1 to i – 1, and the values in right subtree are from i + 1 to n.
    If 1 to i – 1 can form p different trees, and i + 1 to n can form q different trees, then we will have p * q trees when i is the root.
    In fact, the number of different trees depends on how many number to form the tree.
    We can use an array to save the number of different trees that n integers can form.
    We fill the array from bottom to up, starting from 0 to n.
    N[i]表示小于i的前i个数能够形成的BST个数，N[0]表示没有数字的情况下形成的BST个数。
 */

public class Solution {
    public int numTrees(int n) {
        if (n <= 0) return 0;
        int[] DP = new int[n + 1];
        DP[0] = 1; // 乘法所以为1

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                DP[i] += DP[j] * DP[i - j - 1];
            }
        }

        return DP[n];
    }
}
