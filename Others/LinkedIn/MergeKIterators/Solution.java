package MergeKIterators;

import java.util.*;

/**
 * Project: Interviews
 * Package: MergeKIterators
 * Date: 15/Oct/2015
 * Time: 11:01
 * System Time: 11:01 AM
 */
public class Solution {
    List<Iterator<Integer>> iterators;

    public Solution(List<Iterator<Integer>> iterators) {
        this.iterators = iterators;
    }

    public List<Integer> merge() {
        int N = iterators.size();
        PriorityQueue<IterInt> priorityQueue = new PriorityQueue<IterInt>(N, new Comparator<IterInt>(){
            public int compare(IterInt o1, IterInt o2) {
                return o1.next - o2.next;
            }
        });

        for (Iterator<Integer> iterator : iterators) {
            priorityQueue.offer(new IterInt(iterator));
        }

        List<Integer> res = new ArrayList<Integer>();

        while (!priorityQueue.isEmpty()) {
            IterInt iterInt = priorityQueue.poll();
            res.add(iterInt.next);

            if (iterInt.iterator.hasNext()) {
                priorityQueue.offer(new IterInt(iterInt.iterator));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Iterator<Integer> iterator1 = new ArrayList<Integer>(Arrays.asList(10, 20, 30, 40)).iterator();
        Iterator<Integer> iterator2 = new ArrayList<Integer>(Arrays.asList(5, 15, 25, 35, 45, 55)).iterator();
        Iterator<Integer> iterator3 = new ArrayList<Integer>(Arrays.asList(1, 4, 7, 10, 13, 16)).iterator();

        List<Iterator<Integer>> listIterators = new ArrayList<Iterator<Integer>>();
        listIterators.add(iterator1);
        listIterators.add(iterator2);
        listIterators.add(iterator3);

        Solution test = new Solution(listIterators);

        List<Integer> res = test.merge();

        for (Integer i : res) System.out.println(i);
    }
}

class IterInt {
    Iterator<Integer> iterator;
    int next;

    public IterInt(Iterator<Integer> iterator) {
        this.iterator = iterator;
        next = iterator.hasNext() ? iterator.next() : Integer.MAX_VALUE;
    }
}