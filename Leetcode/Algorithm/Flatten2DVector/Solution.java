package Flatten2DVector;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Project: Interviews
 * Package: Flatten2DVector
 * Date: 12/Sep/2015
 * Time: 11:12
 * System Time: 11:12 AM
 */

/*
    Implement an iterator to flatten a 2d vector.

    For example,
    Given 2d vector =

    [
      [1,2],
      [3],
      [4,5,6]
    ]
    By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

    Hint:

    How many variables do you need to keep track?
    Two variables is all you need. Try with x and y.
    Beware of empty rows. It could be the first few rows.
    To write correct code, think about the invariant to maintain. What is it?
    The invariant is x and y must always point to a valid point in the 2d vector. Should you maintain your invariant ahead of time or right when you need it?
    Not sure? Think about how you would implement hasNext(). Which is more complex?
    Common logic in two different places should be refactored into a common method.
    Follow up:
    As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 */

public class Solution {

    Iterator<List<Integer>> outterIter;
    Iterator<Integer> innerIter = Collections.emptyIterator();

    // http://leetcode.tgic.me/flatten-2d-vector/index.html
    public Solution(List<List<Integer>> vec2d) {
        outterIter = vec2d.iterator();
    }

    public int next() {
        return innerIter.next();
    }

    public boolean hasNext() {
        if(innerIter.hasNext()){
            return true;
        }

        if(!outterIter.hasNext()){
            return false;
        }

        innerIter = outterIter.next().iterator();

        return hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */