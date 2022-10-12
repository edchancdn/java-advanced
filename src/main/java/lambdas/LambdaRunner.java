package lambdas;

import java.util.ArrayList;
import java.util.List;

public class LambdaRunner {

    private int v3;

    public static void main(String[] args) {
        /*
        loopOne();
        System.out.println("");
        loopOneLambda();
         */

        loopTwo();
        System.out.println("");
        loopTwoLambda();
        System.out.println("");
        LambdaRunner lr = new LambdaRunner();
        lr.loopTwoLambdaPrivateVar();
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
        for (int num :nums) {
            int v2 = v1 + num;
            System.out.println(v2);
        }
    }

    public static void loopOneLambda() {
        List<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(3);
        nums.add(7);
        nums.add(2);
        nums.forEach(num -> System.out.println(num));
    }

    public static void loopOne() {
        List<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(3);
        nums.add(7);
        nums.add(2);
        for (Integer num :nums) {
            System.out.println(num);
        }
    }

}
