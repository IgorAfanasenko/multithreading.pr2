package school.lemon.changerequest.java.multithreading.pr2;

public class Demo {

    public static void main(String[] args) {
        PrimeNumberSearcher searcher = new MultiThreadPrimeNumberSearcher(8);
        testPrimeNumbersSearcher(searcher, 10000000);
        testPrimeNumbersSearcher(searcher, 1000000);
        testPrimeNumbersSearcher(searcher, 100000);
        testPrimeNumbersSearcher(searcher, 10000);
        testPrimeNumbersSearcher(searcher, 1000);

        searcher = new MultiThreadPrimeNumberSearcher(8);
        testPrimeNumbersSearcher(searcher, 4);
    }

    private static void testPrimeNumbersSearcher(PrimeNumberSearcher searcher, int arraySize) {
        int[] array = ArrayGenerator.generateArray(arraySize);
        System.out.println("Started for array with " + arraySize + " elements.");
        long startTime = System.currentTimeMillis();
        int primeNumbersCount = searcher.countPrimeNumbers(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Finished in: " + (endTime - startTime) + " ms.");
        System.out.println("Result is: " + primeNumbersCount);
    }

}
