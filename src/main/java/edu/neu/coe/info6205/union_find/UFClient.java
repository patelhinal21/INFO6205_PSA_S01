package edu.neu.coe.info6205.union_find;

import java.util.Random;
import edu.neu.coe.info6205.union_find.UF_HWQUPC;

public class UFClient {
    private int n;

    public static int count(int n) {
        UF_HWQUPC uf = new UF_HWQUPC(n);
        Random random = new Random();
        int connections = 0;
        while (uf.components() > 1) {
            int p = random.nextInt(n);
            int q = random.nextInt(n);
            if (!uf.connected(p, q)) {
                uf.union(p, q);

            }
            connections++;

        }
        return connections;
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = count(n);
        System.out.println("number of objects (n) = " + n + " and number of pairs (m) = " + m);
    }
}
