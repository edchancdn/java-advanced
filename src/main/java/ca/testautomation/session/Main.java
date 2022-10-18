package ca.testautomation.session;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String str = "123456789";
        boolean numOnly = str.matches("[0-9]+");
        System.out.println(numOnly);

        Scanner scanner = new Scanner(System.in);
        String str2 = scanner.nextLine();
        System.out.println("input: " + str2);
    }

}