package lambdas;

import org.example.Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class LambdaRunner {

    private int v3;

    public static void main(String[] args) {
        /* Simple Lambda expression
        loopOne();
        System.out.println("");
        loopOneLambda();
         */

        /* Using variables outside of Lambda expression
        loopTwo();
        System.out.println("");
        loopTwoLambda();
        System.out.println("");
        LambdaRunner lr = new LambdaRunner();
        lr.loopTwoLambdaPrivateVar();
         */

        /* Store lambda expression in a variable
        loopThreeLambda();
         */

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



    }

    public String refMethod(String s) {
        return s.toUpperCase();
    }

    public String referenceMethod(String name, Integer term) {
        return name.toUpperCase() + " " + term*12;
    }

    public static void printFormatted(String str, StringFunction format) {
        String result = format.run(str);
        System.out.println(result);
    }

    public static void loopThreeLambda() {
        List<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(7);
        nums.add(6);
        nums.add(2);
        // use Consumer interface to store a lambda expression into a variable
        Consumer<Integer> mthd = n -> System.out.println(n);
        nums.forEach(mthd);
    }

    public void loopTwoLambdaPrivateVar() {
        List<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(7);
        nums.add(6);
        nums.add(2);
        this.v3 = 10;
        nums.forEach(n -> {
            // lambda expression can see a variable outside if it is an instance variable.
            int v2 = this.v3 + n;
            System.out.println(v2);
        });
    }

    public static void loopTwoLambda() {
        List<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(7);
        nums.add(6);
        nums.add(2);
        final int v1 = 10;
        nums.forEach(n -> {
            // lambda expression can see a variable outside if it is effectively final.
            int v2 = v1 + n;
            System.out.println(v2);
        });

    }

    public static void loopTwo() {
        List<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(7);
        nums.add(6);
        nums.add(2);
        int v1 = 10;
        for (int n :nums) {
            int v2 = v1 + n;
            System.out.println(v2);
        }
    }

    public static void loopOneLambda() {
        List<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(3);
        nums.add(7);
        nums.add(2);
        nums.forEach(n -> System.out.println(n));
    }

    public static void loopOne() {
        List<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(3);
        nums.add(7);
        nums.add(2);
        for (Integer n :nums) {
            System.out.println(n);
        }
    }

}
