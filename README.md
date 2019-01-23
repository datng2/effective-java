# Effective Java by examples


### Item 1: Consider `static factory methods` instead of constructor

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
* Return an object of any subtype of


### Item 2: Consider a Builder when faced with many constructor params

* Simplify constructor
* Provide clean code.

### Item 3: Enforce the Singleton property with a private constructor or an enum type

* Make clear that the class is a singleton
* Provide flexibility to change its API later. ? (Item 27)

### Item 4: Enforce noninstaniability via private constructor

* Some utilitiy classes were not designed to **be instaniated**. (e.g. `java.util.Collections`).
* However, these can be subclassed and the subcleass instaniated --> potentially mislead user into thinkings that class was designed for inheritance.
* **Simple Idiom** to ensure noninstantiability - **Private Constructor**

```java
public class UtilityClass {
    // Suppress default constructor for noninstaniability
    private UtilityClass() { throw new AssertionError();}
}
```

### Item 5: Avoid creating unncessary objects

* It is *appropriate* to resuse a single object instead of creating a new functionally equilvalent object each time is needed.
* Reuse can be both faster and more stylish.
* An object can be reused if it is **immutable**.


### Item 6 : Eliminate obsolete object references

* To avoid memory leak.
```java
public class Stack {
    private Object[] elements;
    private int size;

    public void push(Object e) {
        elements[size++] = e;
    }

    public Object pop() {
        // return elements[--size];   // <---- leak here due to osolete references.
        // Better solution - null out array
        Object result = elements[--size];
        elements[size] = null;  // Avoid obsolete reference
        return result;
    }
    
    //...
}
```

* `Obsolete reference` is a reference that will never be dereferenced again.