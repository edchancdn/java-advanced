import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Intro {

    /*
    Variables in a class are called Member Variables or Fields or Properties.
    Variables in a method or code block are called Local Variables.
    Variables in method declarations are called Parameters
     */
    private int counter;
    private static int staticCounter;

    public static void main(String[] args) {
        printNames("John", "Jane", "Will");

        List<Student> students = new ArrayList<>();
        Student s1 = new Student("John", "123");
        students.add(s1);
        Student s2 = new Student("Jane", "456");
        students.add(s2);

        // Sort the list using an inline Comparator.
        students.sort(Comparator.comparing(Student::getName));
        System.out.println(students);
    }

    public void printCounter() {
        /*
        Instance methods can see both private and private static variables.
         */
        counter = 1;
        staticCounter = 10;
    }

    public static void printStaticCounter() {
        /*
        Static methods can only see private static variables.
        It cannot see private variables.
         */
        staticCounter = 10;
    }

    public static void printNames(String ... names) {
        /*
        ... is called variable arguments or VarArgs
        which allows any number of parameters from 0 to n.
        The values are passed as an array.
        This is also called a spread.
         */
        for (String name :names) {
            System.out.println(name);
        }
    }


}

class Student {
    private String name;
    private String studentNumber;

    public Student(String name, String studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

}
