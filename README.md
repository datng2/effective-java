# Effective Java by examples


## Item 1: Consider `static factory methods` instead of constructor

Pros:

* Has names --> Improve code readability
    ```java
    // Static factory method
    BigInteger.probablePrime

    // Regular constructor --> probably return a prime
    BigInteger(int, int, Random)
    ```
* Avoid multiple constructors --> easier for end users to 
* Doesn't require to create a new object.
