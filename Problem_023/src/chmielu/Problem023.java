package chmielu;

import java.util.ArrayList;

/**
 * Created by kuba on 14.02.15.
 */
public class Problem023 {
  public static final int SMALLES_ABUNDANT_NUMBER = 12;
  private static final int TARGET = 28123;

  public static void main(String[] args) {
    long timeStart = System.nanoTime();

    int[] primes = numberUtils.setupPrimes(TARGET);
    
    //find all abundant numbers less than TARGET
    ArrayList<Integer> abundants = new ArrayList<Integer>();
    for (int n = SMALLES_ABUNDANT_NUMBER; n < TARGET; n++) {
      if (numberUtils.sumOfArrayElements(numberUtils.findDivisorsByPrimeFactorization(n, primes)) > n) {
        abundants.add(n);
      }
    }
    int[] abu = numberUtils.ArrayListIntegerToArrayInt(abundants);
//    numberUtils.printArray(abu, System.out);

    //find numbers that are not sums of 2 abundant numbers.
    int sum = 0;
    int lastN = 0;
    boolean[] isSumOfAbundantNumbers = new boolean[TARGET];
    for (int i = 1; i < isSumOfAbundantNumbers.length; i++) {
      isSumOfAbundantNumbers[i] = true;
    }
    for (int i = 0; i < abu.length; i++) {
      for (int j = i; j < abu.length; j++) {
        int checkedNumber = abu[i] + abu[j];
        if (checkedNumber < isSumOfAbundantNumbers.length) {
          isSumOfAbundantNumbers[checkedNumber] = false;
        }
      }
    }
    for (int i = 1; i < isSumOfAbundantNumbers.length; i++) {
      if (isSumOfAbundantNumbers[i]) {
        sum += i;
        lastN = i;
      }
    }
//    for (int n = 1; n <= TARGET; n++) {
//      if (!isSumOfTwoNumbers(n, abu)) {
//        sum += n;
//        lastN = n;
//      }
//    }
    long timeEnd = System.nanoTime();
    System.out.println("Biggest number: "+lastN);
    System.out.println("Sum: "+sum);
    System.out.println("Time: "+ ((timeEnd-timeStart)/1000000000.0));
  }

  public static boolean isSumOfTwoNumbers(int n, int[] possibleSummands) {
    for (int i = 0; i < possibleSummands.length; i++) {
      for (int j = i; j < possibleSummands.length; j++) {
        if (possibleSummands[i] + possibleSummands[j] == n) {
          return true;
        }
      }
    }
    return false;
  }
}
