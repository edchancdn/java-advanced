package lambdas;

import interfaces.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LambdaRunner {

    private int v3;

    public static void main(String[] args) {
        /*

        // Simple Lambda expression
        loopOne();
        System.out.println("");
        loopOneLambda();

        // Using variables outside of Lambda expression
        loopTwo();
        System.out.println("");
        loopTwoLambda();
        System.out.println("");
        LambdaRunner lr = new LambdaRunner();
        lr.loopTwoLambdaPrivateVar();

        // Store lambda expression in a variable
        loopThreeLambda();

        // Lambda method reference
        loopFourLambdaMethodRef();

        // Lambda expression with objects
        loopFiveLambdaObj();

        // Custom functional interface
         */

        loopSixCustomFuncInterface();

        /* Session: 2022-10-12

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
        Consumer<Integer> mthd = LambdaRunner::printGreeting;
        // Consumer is a functional interface that requires a single argument and returns no results,
        //   method printGreeting() is created to match this signature.
        // Note how method loopThreeLambda() uses an inline lambda expression of the same output.
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
