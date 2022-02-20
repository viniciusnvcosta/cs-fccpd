package school.cesar.fccpd;

import java.util.Scanner;

public class Main {
    // public static final int[] values = { 6978, 4574, 6557, 1952, 5841 };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
		System.out.print("Array size: ");
		Integer amountNumbers = sc.nextInt();
		sc.close();

        Generator values[] = new Generator[amountNumbers];
        for (int i = 0; i < amountNumbers; i++) {
            values[i] = new Generator();
		}

        Thread t1 = new myThread(values);

        long startTimeMain = System.nanoTime();
        computePrimeFactors(values);
        long totalTimeMain = (long) ((System.nanoTime() - startTimeMain) * 0.000001);
        System.out.println("main execution time: " + totalTimeMain + "ms");

        t1.start();
    }

    public static int[] computePrimeFactors(Generator[] values) {
        int[] factors = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            factors[i] = numPrimeFactors(values[i]);
        }
        return factors;
    }

    public static int numPrimeFactors(Generator values) {
        int primeFactors = 0;
        int n = values.number;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                primeFactors++;
                n /= i;
            }
        }
        return primeFactors;
    }
}
