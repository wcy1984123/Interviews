package SlidingWindowMaximum;

import java.util.LinkedList;
import java.util.List;

/**
 * Project: Interviews
 * Package: SlidingWindowMaximum
 * Date: 12/Sep/2015
 * Time: 10:59
 * System Time: 10:59 AM
 */

/*
    Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

    For example,
    Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

    Window position                Max
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7
    Therefore, return the max sliding window as [3,3,5,5,6,7].

    Note:
    You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

    Follow up:
    Could you solve it in linear time?

    Hint:

    How about using a data structure such as deque (double-ended queue)?
    The queue size need not be the same as the window’s size.
    Remove redundant elements and the queue should store only elements that need to be considered.
 */

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0) return new int[0];
        LinkedList<Integer> descList = new LinkedList<Integer>();
        int[] res = new int[nums.length+1-k];

        // add the previous k - 1 elements in the array
        for(int i=0;i<k-1;i++) addDescList(descList,nums[i]);

        // get the max slide window
        for(int i=0;i<res.length;i++){
            // 在 descList里面的 value 按照降序排序
            addDescList(descList,nums[i+k-1]);
            res[i] = descList.getFirst();
            if(nums[i]==descList.getFirst()) descList.removeFirst(); //to delete the left most.
        }
        return res;
    }

    // 删除所有小于等于num的数目，因为不会影响 max 的值
    public void addDescList(List<Integer> descList, int num){
        while(!descList.isEmpty()&&num>descList.get(descList.size() - 1)) descList.remove(descList.size() - 1);
        descList.add(num);
    }
}
