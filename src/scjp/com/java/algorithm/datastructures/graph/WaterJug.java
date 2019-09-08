package scjp.com.java.algorithm.datastructures.graph;

/*
    m litre jug and a n litre jug where 0 < m < n. Target d < n

    Fill the m litre jug and empty it into n litre jug.
    Whenever the m litre jug becomes empty fill it.
    Whenever the n litre jug becomes full empty it.
    Repeat steps 1,2,3 till either n litre jug or the m litre jug contains d litres of water.
*/

import java.util.HashSet;
import java.util.Set;

public class WaterJug {

    public static void printStates(int m, int n, int d) {
        Set<Pair> set = new HashSet<>();

        Pair currState = new Pair(0, 0);
        while (set.add(currState)) {
            System.out.println(currState);
            int mm = currState.x, nn = currState.y;
            if (mm == 0) {
                mm = m;
            } else if (nn == n) {
                nn = 0;
            } else {
                int remainingInN = n - nn;
                if (remainingInN < mm) {
                    mm = m - remainingInN;
                    nn = n;
                } else if(remainingInN >= mm) {
                    nn = nn + mm;
                    mm = 0;
                }

                if (mm == d || nn == d) {
                    System.out.println(new Pair(mm, nn));
                    break;
                }
            }
            currState = new Pair(mm, nn);
        }

    }

    public static void main(String[] args) {
        printStates(3, 5, 4);
    }
}
