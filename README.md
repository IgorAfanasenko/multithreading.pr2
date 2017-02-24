Multithreading HW2
==================

#### Prime Numbers

Create class, that calculates amount of prime numbers in specified array.
There should be at least 3 implementations:
* single thread implementation
* using divide and conquer algorithm with *java.util.concurrent.ForkJoinPool*, you can either use RecursiveTask or RecursiveAction (implementing for both ways is a big plus)
* using divide and conquer algorithm **without** *java.util.concurrent.ForkJoinPool*

Create demo class where you should compare performance for each implementation.
There should be testing at least on 5 arrays with different length: 10000000, 1000000, 100000, 10000, 1000. 

**NOTES**:
* A prime number (or a prime) is a natural number greater than 1 that has no positive divisors other than 1 and itself.
* Make your implementation flexible, so one implementation can be easily replaced by another.
* Create unit tests for most important method like verification for prime, and calculation amount of prime numbers in array/part of array.  
