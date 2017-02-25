package school.lemon.changerequest.java.multithreading.pr2;

public class MultiThreadPrimeNumberSearcher extends PrimeNumberSearcher {

    private final int maxThreadsCount;

    public MultiThreadPrimeNumberSearcher(int maxThreadsCount) {
        if (maxThreadsCount < 1) {
            throw new IllegalArgumentException();
        }
        this.maxThreadsCount = maxThreadsCount;
    }

    @Override
    public int countPrimeNumbers(int[] values) {
        Searcher[] workers = startWorkers(values);
        return getFinalResult(workers);
    }

    private Searcher[] startWorkers(int[] values) {
        int threadsCount = values.length > maxThreadsCount ? maxThreadsCount : values.length;
        Searcher[] workers = new Searcher[threadsCount];
        int valuesPerThread = values.length / workers.length;
        for (int i = 0; i < workers.length; i++) {
            int upperBound = (i == workers.length - 1) ? values.length : valuesPerThread * (i + 1);
            workers[i] = new Searcher(values, valuesPerThread * i, upperBound);
            workers[i].start();
        }
        return workers;
    }

    private int getFinalResult(Searcher[] workers) {
        try {
            int result = 0;
            for (Searcher worker : workers) {
                worker.join();
                result += worker.getCount();
            }
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private class Searcher extends Thread {

        private int[] values;
        private int lowerBound;
        private int upperBound;
        private int count;

        private Searcher(int[] values, int lowerBound, int upperBound) {
            this.values = values;
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
            this.count = 0;
        }

        @Override
        public void run() {
            for (int i = lowerBound; i < upperBound; i++) {
                if (isPrime(values[i])) {
                    ++count;
                }
            }
        }

        public int getCount() {
            return count;
        }

    }


}
