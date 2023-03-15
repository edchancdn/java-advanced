package designpatterns;

public class Employee {

    private static volatile Employee instance;
    private String name;
    private int age;

    private Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Employee getInstance(String name, int age) {
        Employee employee = instance;
        if (employee != null) {
            return employee;
        }
        synchronized (Employee.class) {
            if (instance == null) {
                instance = new Employee(name, age);
            }
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
