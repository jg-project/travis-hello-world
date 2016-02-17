package jgproject.travis.lecture_four;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsEverywhere {

    ExecutorService executor;

    PrimeCruncherFactory factory;

    int threadNumbers;

    public ThreadsEverywhere(ExecutorService executor, PrimeCruncherFactory factory, int threadNumbers) {
        this.executor = executor;
        this.factory = factory;
        this.threadNumbers = threadNumbers;
    }

    public void crunchIt(long from, long to) throws InterruptedException {
        Collection<Callable<Void>> tasks = new ArrayList<>();
        long delta = (to - from) / threadNumbers;

        for (int i = 0; i < threadNumbers; i++) {
            tasks.add(new Task(from + delta * i, from + delta * (i + 1), factory.getPrimeCruncher()));
        }
        executor.invokeAll(tasks);
    }

    public static class Task implements Callable {

        private final PrimeCruncher primeCruncher;

        private final long from;

        private final long to;

        public Task(long from, long to, PrimeCruncher primeCruncher) {
            this.from = from;
            this.primeCruncher = primeCruncher;
            this.to = to;
        }

        @Override
        public Void call() throws Exception {
            long current = from;
            while (current++ < to) {
                if (primeCruncher.isPrime(current)) {
                    System.out.println(Thread.currentThread().getName() + ":" + current);
                }
            }
            return null;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int nThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        ThreadsEverywhere t = new ThreadsEverywhere(executor,new PrimeCruncherFactoryImp(),nThreads);
        t.crunchIt(1, 1000000);
        executor.shutdownNow();

    }

}
