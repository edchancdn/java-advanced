package lambdas;

import interfaces.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LambdaRunner {

    private int v3;

    public static void main(String[] args) {

        /* Session 1

        // Simple Lambda expression
        System.out.println("---loopOne---");
        loopOne();
        System.out.println("---loopOneLambda---");
        loopOneLambda();

        // Using variables outside of Lambda expression
        System.out.println("---loopTwo---");
        loopTwo();
        System.out.println("---loopTwoLambda---");
        loopTwoLambda();
        System.out.println("---loopTwoLambdaPrivateVar---");
        LambdaRunner lr = new LambdaRunner();
        lr.loopTwoLambdaPrivateVar();

        // Store lambda expression in a variable
        System.out.println("---loopThreeLambda---");
        loopThreeLambda();

        // Lambda method reference
        System.out.println("---loopFourLambdaMethodRef---");
        loopFourLambdaMethodRef();

        // Lambda expression with objects
        System.out.println("---loopFiveLambdaObj---");
        loopFiveLambdaObj();

        // Custom functional interface
        System.out.println("---loopSixCustomFuncInterface---");
        loopSixCustomFuncInterface();

         */



        /* Session: 2 - 2022-10-12

        System.out.println("");
        System.out.println("---Advanced Java Session: 2022-10-12---");

        StringFunction exclaim = (s) -> s + "!";
        printFormatted("Hello", exclaim);

        // input: 2 Integers (first 2 params)
        // output: Integer (last param)
        BiFunction<Integer, Integer, Integer> func = (z1, z2) -> z1 + z2;
        // execute "apply" method
        Integer result = func.apply(5, 8);
        System.out.println(result);

        // BiPredicate
        BiPredicate<String, Integer> funcBp = (y1, y2) -> {
            return y1.length() == y2;
        };
        // execute test method
        boolean isSameLength = funcBp.test("hello", 4);
        System.out.println(isSameLength);

        // BiFunction with Reference Method
        BiFunction<String, Integer, String> biFunction = new LambdaRunner()::referenceMethod;
        System.out.println(biFunction.apply("Hello", 3));

        Supplier<String> s  = ()-> "Hello";
        System.out.println(s.get());

        // inferred type
        Supplier<?> supplier = Collections::emptyMap;
        System.out.println("supplier value: " + supplier.get());

        */



        /* Session: 3 - 2023-03-15

         */

        // ----- Supplier

        // Supplies a String
        Supplier<String> str = () -> "Hello";
        System.out.println(str.get());

        // Supplies a Car object
        Supplier<Car> carSupplier = () -> new Car("Audi", "A4", "red");
        Car car = carSupplier.get();
        System.out.println(car);

        // ----- Consumer
        // Consumes a string
        Consumer<String> stringConsumer = x -> System.out.println("Hello " + x);
        stringConsumer.accept("Mr Smith");

    }

    public String refMethod(String s) {
        return s.toUpperCase();
    }

    public String referenceMethod(String name, Integer term) {
        return name.toUpperCase() + " " + term * 12;
    }

    public static void loopSixCustomFuncInterface() {
        // Just to showcase custom functional interface StringFunction
        // The same can be achieved through interface Function<String, String>
        StringFunction shout = s -> s + "!";
        StringFunction ask = s -> s + "?";

        printFormatted("Hi there", shout);
        printFormatted("How are you", ask);
        printFormatted("How was your day", ask);

        System.out.println("");

        // Use with collection
        // this code block will produce the same output
        List<GreetPerson> greets = new ArrayList<>();
        greets.add(new GreetPerson("Hi there", shout));
        greets.add(new GreetPerson("How are you", ask));
        greets.add(new GreetPerson("How was your day", ask));
        greets.forEach(LambdaRunner::printGreeting);
    }

    private static void printGreeting(GreetPerson person) {

        printFormatted(person.greeting, person.type);
    }

    public static void printFormatted(String str, StringFunction format) {
        String result = format.apply(str);
        System.out.println(result);
    }
    public static void loopFiveLambdaObj() {
        List<Car> cars = buildObjList();

        // using inline lambda expression
        Consumer<Car> prcCar = n -> System.out.println("Car model: " + n.getModel());
        cars.forEach(prcCar);

        System.out.println("");

        // using Method reference
        cars.forEach(LambdaRunner::processCar);
    }

    public static void processCar(Car car) {
        System.out.println("Car model: " + car.getModel());
        car.startEngine();
        car.stopEngine();
    }

    private static List<Car> buildObjList() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("sedan", "A4", "silver"));
        cars.add(new Car("wagon", "A5", "blue"));
        cars.add(new Car("coupe", "RS5", "white"));
        return cars;
    }

    public static void loopFourLambdaMethodRef() {
        List<Integer> nums = buildList();

        // Use Consumer interface to store a lambda expression into a variable.
        // Use Method reference.
        // Syntax -  Class::referencedMethod
        // Consumer is a functional interface that requires a single argument and returns no results,
        //   method printGreeting() is created to match this signature.
        // Note how method loopThreeLambda() uses an inline lambda expression of the same output.
        Consumer<Integer> mthd = LambdaRunner::printGreeting;
        nums.forEach(mthd);

        System.out.println("");

        // This code block has the same output as the lambda implementation
        for (Integer num :nums) {
            printGreeting(num);
        }

        System.out.println("");

        // This line has the same output as the lambda implementation.
        nums.forEach(LambdaRunner::printGreeting);
    }

    public static void printGreeting(Integer num) {
        System.out.println("Hello " + num);
    }

    public static void loopThreeLambda() {
        List<Integer> nums = buildList();
        // use Consumer interface to store a lambda expression into a variable
        Consumer<Integer> mthd = n -> System.out.println("Hello " + n);
        nums.forEach(mthd);
    }

    public void loopTwoLambdaPrivateVar() {
        List<Integer> nums = buildList();
        this.v3 = 10;
        nums.forEach(n -> {
            // lambda expression can see a variable outside if it is an instance variable.
            int v2 = this.v3 + n;
            System.out.println(v2);
        });
    }

    public static void loopTwoLambda() {
        List<Integer> nums = buildList();
        final int v1 = 10;
        nums.forEach(n -> {
            // lambda expression can see a variable outside if it is effectively final.
            int v2 = v1 + n;
            if (v2 > 15) {
                System.out.println("greater than 15: " + v2);
            }
            System.out.println(v2);
        });
    }

    public static void loopTwo() {
        List<Integer> nums = buildList();
        int v1 = 10;
        for (int n :nums) {
            int v2 = v1 + n;
            System.out.println(v2);
        }
    }

    public static void loopOneLambda() {
        List<Integer> nums = buildList();
        nums.forEach(n -> System.out.println(n));
    }

    public static void loopOne() {
        List<Integer> nums = buildList();
        for (Integer n :nums) {
            System.out.println(n);
        }
    }

    private static List<Integer> buildList() {
        List<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(7);
        nums.add(6);
        nums.add(2);
        return nums;
    }

}
