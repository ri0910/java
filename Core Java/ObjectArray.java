
class Student{
    int id;
    String name;
    int marks;
}




public class ObjectArray {
    public static void main(String[] args) {
        Student students[] = new Student[3];
        Student s1 = new Student();
        s1.id = 1;
        s1.name = "Ram";
        s1.marks = 50;


        Student s2 = new Student();
        s2.id = 2;
        s2.name = "Shayam";
        s2.marks =80;


        Student s3 = new Student();
        s3.id = 3;
        s3.name = "Riya";
        s3.marks = 90;


        students[0] = s1;
        students[1] = s2;
        students[2] = s3;

        for(Student s : students){
            System.out.println("ID : " + s.id + ", Name : " + s.name + ", Marks : "+ s.marks );
        }
    }
}
