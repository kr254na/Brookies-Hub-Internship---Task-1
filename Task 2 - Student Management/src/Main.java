import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    static ArrayList<Student> students=new ArrayList<>();
    static void addStudent(Student s)
    {
        students.add(s);
    }
    static void removeStudent(int id)
    {
        for(Student student:students)
        {
            if(student.id==id)
            {
                students.remove(student);
            }
        }
    }
    static void displayStudents()
    {
        for(Student student:students)
        {
            System.out.println(student);
        }
    }
    public static void main(String args[])
    {
        while(true)
        {
            System.out.println("Enter 1 to add student");
            System.out.println("Enter 2 to remove student");
            System.out.println("Enter 3 to display students");
            System.out.println("Enter 4 to exit");
            Scanner sc=new Scanner(System.in);
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                    System.out.println("Enter the id:");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the name");
                    String s=sc.nextLine();
                    System.out.println("Enter the grade:");
                    char c=sc.nextLine().charAt(0);
                    addStudent(new Student(id,s,c));
                    break;
                case 2:
                    System.out.println("Enter the id to remove:");
                    int deletedId=sc.nextInt();
                    removeStudent(deletedId);
                    break;
                case 3:
                    displayStudents();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}