package UnionFind;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Project: Interviews
 * Package: UnionFind
 * Date: 14/Mar/2015
 * System Time: 8:25 AM
 */

public class Applications {
    //------------------------------------ Application 1 ------------------------------------//
    public static boolean valid_tree(int n, ArrayList<int[]> edges) {

        if (n == 0 || edges.isEmpty())
            return false;

        UnionFind uf = new UnionFind(n); // make sets

        /*
        determine if two endpoints in one edge belongs to the same set
        if they belong to the same set, it means that there is a cycle.
        otherwise it is a valid tree without cycle.
        It can be considered in this way:
        there are two sets: one with nodes without being connected by edges, the other one with nodes being connected by edges
        If it came across two nodes in one edges belong to one set, other than in the above two sets, it means that there is a cycle in one set.
        */

        for (int[] p : edges) {
            // each edge has two endpoints
            if (uf.find(p[0]) == uf.find(p[1])) {
                return false;
            }
            uf.union(p[0], p[1]);
        }
        return uf.num_sets() == 1;
    }

    //------------------------------------ Application 2 ------------------------------------//
    public static class Contact {
        String name;
        ArrayList<String> emails;

        public Contact(String name, ArrayList<String> emails) {
            this.name = name;
            this.emails = emails;
        }

        public String toString() {
            String ret = name + ": " + emails.toString();
            return ret;
        }
    }

    public static ArrayList<ArrayList<Contact>> group_contacts(ArrayList<Contact> input) {

        // key : email 		value : a list of user ids
        HashMap<String, ArrayList<Integer>> email_record = new HashMap<String, ArrayList<Integer>>();

        // group users with the same email into the same group
        int n = input.size();
        for (int k = 0; k < input.size(); k++) {
            for (String email : input.get(k).emails) {
                ArrayList<Integer> tmp = email_record.get(email);
                if (tmp != null)
                    tmp.add(k);
                else {
                    tmp = new ArrayList<Integer>();
                    tmp.add(k);
                }
                email_record.put(email, tmp);
            }
        }

        System.out.println(email_record);

        // group users with the same email into one set using union-find data structure
        UnionFind uf = new UnionFind(n);
        for (ArrayList<Integer> p : email_record.values()) {
            for (int i = 0; i < p.size() - 1; i++) {
                uf.union(p.get(i), p.get(i + 1));
            }
        }


        HashMap<Integer, ArrayList<Integer>> groups = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            int val = uf.find(i);
            ArrayList<Integer> tmp = groups.get(val);
            if (tmp != null)
                tmp.add(i);
            else {
                tmp = new ArrayList<Integer>();
                tmp.add(i);
            }
            groups.put(val, tmp);
        }

        ArrayList<ArrayList<Contact>> ret = new ArrayList<ArrayList<Contact>>();
        for (ArrayList<Integer> p : groups.values()) {
            ArrayList<Contact> vs = new ArrayList<Contact>();
            for (int c : p)
                vs.add(input.get(c));
            ret.add(vs);
        }
        return ret;
    }

    public static void main(String[] args) {
        int n = 5;
        // int[] a = {{0,1}, {0,2}, {2,3}, {2,4}}
        int[] a = {0, 1}, e = {1, 2}, b = {0, 2}, c = {2, 3}, d = {2,
                4};
        ArrayList<int[]> al = new ArrayList<int[]>();
        al.add(a);
        al.add(b);
        al.add(c);
        al.add(d);
        al.add(e);
        System.out.println(valid_tree(n, al));

        // { "John", {"john@gmail.com"} },
        // { "Mary", {"mary@gmail.com"} },
        // { "John", {"john@yahoo.com"} },
        // { "John", {"john@gmail.com", "john@yahoo.com", "john@hotmail.com"} },
        // { "Bob", {"bob@gmail.com"} }
        ArrayList<Contact> input = new ArrayList<Contact>();
        ArrayList<String> e1 = new ArrayList<String>();
        e1.add("john@gmail.com");
        Contact c1 = new Contact("John", e1);
        ArrayList<String> e2 = new ArrayList<String>();
        e2.add("mary@gmail.com");
        Contact c2 = new Contact("Mary", e2);
        ArrayList<String> e3 = new ArrayList<String>();
        e3.add("john@yahoo.com");
        Contact c3 = new Contact("John", e3);
        ArrayList<String> e4 = new ArrayList<String>();
        e4.add("john@gmail.com");
        e4.add("john@yahoo.com");
        e4.add("john@hotmail.com");
        Contact c4 = new Contact("John", e4);
        ArrayList<String> e5 = new ArrayList<String>();
        e5.add("bob@gmail.com");
        Contact c5 = new Contact("Bob", e5);
        input.add(c1);
        input.add(c2);
        input.add(c3);
        input.add(c4);
        input.add(c5);

        System.out.println(group_contacts(input));

        // UnionFind uf = new UnionFind(5);
        // System.out.println(uf);
        //
        // uf.union(1, 2);
        // System.out.println("union 1 2");
        // System.out.println(uf);
        //
        // uf.union(1, 2);
        // System.out.println("union 1 2");
        // System.out.println(uf);
        //
        // uf.union(3, 4);
        // System.out.println("union 3 4");
        // System.out.println(uf);
        //
        // uf.union(1, 0);
        // System.out.println("union 1 0");
        // System.out.println(uf);
        //
        // uf.union(1, 3);
        // System.out.println("union 1 3");
        // System.out.println(uf);
        //
        // uf.find(4);
        // System.out.println("find 4");
        // System.out.println(uf);

    }

	/*
     *
	 * The tests in main should produce:
	 *
	 * <UnionFind p [0, 1, 2, 3, 4] r [0, 0, 0, 0, 0] > union 1 2 <UnionFind p
	 * [0, 1, 1, 3, 4] r [0, 1, 0, 0, 0] > union 1 2 <UnionFind p [0, 1, 1, 3,
	 * 4] r [0, 1, 0, 0, 0] > union 3 4 <UnionFind p [0, 1, 1, 3, 3] r [0, 1, 0,
	 * 1, 0] > union 1 0 <UnionFind p [1, 1, 1, 3, 3] r [0, 1, 0, 1, 0] > union
	 * 1 3 <UnionFind p [1, 1, 1, 1, 3] r [0, 2, 0, 1, 0] > find 4 <UnionFind p
	 * [1, 1, 1, 1, 1] r [0, 2, 0, 1, 0] >
	 */
}


