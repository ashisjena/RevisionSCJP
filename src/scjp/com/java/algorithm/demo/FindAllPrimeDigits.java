package scjp.com.java.algorithm.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Sieve of Eratosthenes algorithm
public class FindAllPrimeDigits {
  public static void main(String[] args) {
    new Thread(null, new MyThread(100), "", 256L * 1 << 6).start();

    List<Integer> primeNums = Stream.generate(new GetNextNum()::getNextNum)
                                    .limit(100)
                                    .filter(n -> {
                                      if ((n <= 1 || n % 2 == 0) && n != 2) {
                                        return false;
                                      } else {
                                        long maxDivisor = (long) Math.ceil(Math.sqrt(n));
                                        for (int num = 3; num <= maxDivisor; num += 2) {
                                          if (n % num == 0) {
                                            return false;
                                          }
                                        }
                                        return true;
                                      }
                                    })
                                    .collect(Collectors.toList());
    System.out.println(primeNums);
  }

  static class GetNextNum {
    int i = 0;

    int getNextNum() {
      return ++i;
    }
  }

  static class MyThread implements Runnable {
    private final int upperBound;

    MyThread(final int value) {
      upperBound = value;
    }

    @Override
    public void run() {
      final int sqrtUpperBound = (int) Math.sqrt(upperBound);

      final boolean[] isComposite = new boolean[upperBound + 1];
      List<Integer> primeIntegers = new ArrayList<Integer>();
      for (int i = 2; i <= sqrtUpperBound; i++) {
        if (!isComposite[i]) {
          primeIntegers.add(i);
          for (int j = i * i; j <= upperBound; j += i)
            isComposite[j] = true;
        }
      }

      for (int i = sqrtUpperBound; i <= upperBound; i++)
        if (!isComposite[i])
          primeIntegers.add(i);

      System.out.println(primeIntegers);
    }
  }
}