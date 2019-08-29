package scjp.com.java.algorithm.recursion;

public class FebonaciiSeries {
    public static Integer n = 10;

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.print(febonaciiRecur(i) + " ");
            System.out.print(febonacii(i));
            System.out.println();
        }
    }

    private static int febonaciiRecur(int num) {
//        System.out.println("recur");
        if (num == 0 || num == 1)
            return num;
        else
            return febonaciiRecur(num - 1) + febonaciiRecur(num - 2);
    }

    private static int febonacii(int num) {
        if (num == 0 || num == 1) {
            return num;
        }

        int p1 = 0;
        int p2 = 1;
        for (int i = 2; i <= num; i++) {
//            System.out.println("loop");
            int temp = p2 + p1;
            p1 = p2;
            p2 = temp;
        }

        return p2;
    }
}