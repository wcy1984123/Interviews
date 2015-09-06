package CourseScheduleII;

import java.util.LinkedList;

/**
 * Project: Interviews
 * Package: CourseScheduleII
 * Date: 05/Sep/2015
 * Time: 21:41
 * System Time: 9:41 PM
 */

/*
    There are a total of n courses you have to take, labeled from 0 to n - 1.

    Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

    Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

    There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

    For example:

    2, [[1,0]]
    There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

    4, [[1,0],[2,0],[3,1],[3,2]]
    There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

    Note:
    The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

    click to show more hints.

    Hints:
    This problem is equivalent to finding the topological order in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
    Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
    Topological sort could also be done via BFS.
 */

public class Solution {
    // If we use the DFS solution of Course Schedule, a valid sequence can easily be recorded.
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
            throw new IllegalArgumentException("illegal prerequisites array");
        }

        int len = prerequisites.length;

        //if there is no prerequisites, return a sequence of courses
        if(len == 0){
            int[] res = new int[numCourses];
            for(int m=0; m<numCourses; m++){
                res[m]=m;
            }
            return res;
        }

        //records the number of prerequisites each course (0,...,numCourses-1) requires
        int[] pCounter = new int[numCourses];
        for(int i=0; i<len; i++){
            pCounter[prerequisites[i][0]]++;
        }

        //stores courses that have no prerequisites
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(pCounter[i]==0){
                queue.add(i);
            }
        }

        int numNoPre = queue.size();

        //initialize result
        int[] result = new int[numCourses];
        int j=0;

        while(!queue.isEmpty()){
            int c = queue.remove();
            result[j++]=c;

            for(int i=0; i<len; i++){
                if(prerequisites[i][1]==c){
                    pCounter[prerequisites[i][0]]--;
                    if(pCounter[prerequisites[i][0]]==0){
                        queue.add(prerequisites[i][0]);
                        numNoPre++;
                    }
                }

            }
        }

        //return result
        if(numNoPre==numCourses){
            return result;
        }else{
            return new int[0];
        }
    }
}
