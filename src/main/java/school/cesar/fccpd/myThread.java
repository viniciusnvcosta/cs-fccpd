package school.cesar.fccpd;

public class myThread extends Thread{

    private Generator values[];

    public myThread(Generator[] values) {
        this.values = values;
	}

public void run() {
        System.out.println("Second Thread: " + Thread.currentThread().getId());


        long startTimeThread = System.nanoTime();
        Main.computePrimeFactors(values);
        long totalTimeThread = (long) ((System.nanoTime() - startTimeThread) * 0.000001);

        System.out.println(Thread.currentThread().getName() +
         " execution time: " + totalTimeThread + "ms");

        System.out.println("End of Thread ID: " + Thread.currentThread().getId());
    }
}