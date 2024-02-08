import java.util.*;

class Student implements Comparable<Student>{

    int age;
    String name;
    
    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }



    @Override
    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }



    public int compareTo(Student o) {
        if(this.age > o.age){
            return 1;
        }
        else{
            return -1;
        }
    }
    
}

public class ComparableConcept {
    public static void main(String[] args) {
        
        List<Student> studs = new ArrayList<Student>();
        studs.add(new Student(23, "Harry"));
        studs.add(new Student(21, "Harmoine"));
        studs.add(new Student(25, "Ron"));
        studs.add(new Student(12, "Malfoy"));

        Collections.sort(studs);
        for(Student student : studs){
            System.out.println(student);
        }
    }
}
