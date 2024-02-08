import java.util.*;

class Student{
    private int age;
    private String name;
    public Student() {
    }
    public Student(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }

    
}

public class ConstructorReference {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Riya", "Raja", "Rehan");

        List<Student> students = new ArrayList<Student>();

        students = names.stream().map(Student::new).toList();

        students.forEach(System.out::println);
    }
}
