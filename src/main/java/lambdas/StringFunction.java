package lambdas;

// My custom functional interface
// Requires a String and returns a String result.
// This is just an exercise, the same can be achieved through the Function<T,R> interface
@FunctionalInterface
public interface StringFunction {
    String apply(String str);
}
