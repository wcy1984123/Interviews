package UnionFind;

import java.util.Arrays;

/**
 * Project: Interviews
 * Package: UnionFind
 * Date: 13/Mar/2015
 * System Time: 8:25 AM
 */

/**
 * 1. simple union-find based on int[] arrays for  "parent" and "rank"
 * implements the "disjoint-set forests" described at
 * http://en.wikipedia.org/wiki/Disjoint-set_data_structure
 * which have almost constant "amortized" cost per operation
 * (actually O(inverse Ackermann))
 * 2. Apply both rank and path compression techniques to improve time complexity.
 * *
 */


public class UnionFind {

    private int[] _parent; // record each element's parent node
    private int[] _rank; // record each element's rank

    // make set for each element
    // constructor for initializing sets
    public UnionFind(int max) {

        _parent = new int[max];
        _rank = new int[max];

        for (int i = 0; i < max; i++) {
            _parent[i] = i;
        }
    }

    // using path compression
    public int find(int i) {

        int p = _parent[i];
        if (i == p) {
            return i;
        }
        return _parent[i] = find(p);

    }

    // using rank to guide set with smaller rank to attach to the set with the bigger rank
    public void union(int i, int j) {

        int root1 = find(i);
        int root2 = find(j);

        if (root2 == root1)
            return;

        if (_rank[root1] > _rank[root2]) {
            _parent[root2] = root1;
        } else if (_rank[root2] > _rank[root1]) {
            _parent[root1] = root2;
        } else {
            _parent[root2] = root1;
            _rank[root1]++;
        }
    }

    // count the number of sets
    public int num_sets() {
        int count = 0;
        for (int i = 0; i < _parent.length; ++i) {
            if (_parent[i] == i)
                count++;
        }
        return count;
    }

    public String toString() {
        return "<UnionFind\np " + Arrays.toString(_parent) + "\nr "
                + Arrays.toString(_rank) + "\n>";
    }

}
