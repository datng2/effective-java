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

* Bad:

```java

// Client code:
/// NutritionFacts cocaCola = new NutritionFacts(240, 8, 100, 0, 35, 27);

public class NutritionFacts { 
    private final int servingSize; 
    private final int servings; 
    private final int calories; 
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize  = servingSize;
        ....
    }
    public NutritionFacts(int servingSize, int servings) {
            this(servingSize, servings, 0);}
    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }
    ...
}
```

* Builder pattern

```java
// Client code:
//     NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
//                                                 .calories(100)
//                                                 .sodium(35)
//                                                 .carbohydrate(27)
//                                                 .build();
// Builder Pattern
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;
    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;
        // Optional parameters - initialized to default values
        private int calories      = 0;
        private int fat           = 0;
        private int carbohydrate  = 0;
        private int sodium        = 0;
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings    = servings;
        }
        public Builder calories(int val)
            { calories = val;      return this; }
        public Builder fat(int val)
            { fat = val;           return this; }
        public Builder carbohydrate(int val)
            { carbohydrate = val;  return this; }
        public Builder sodium(int val)
            { sodium = val;        return this; }
        public NutritionFacts build() {
            return new NutritionFacts(this);
} }
    private NutritionFacts(Builder builder) {
        servingSize  = builder.servingSize;
} }
```


### Item 3: Enforce the Singleton propety with a private constructor or an enum type

Singleton: a class that instani