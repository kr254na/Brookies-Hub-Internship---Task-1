import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main
{
    static ArrayList<Employee> employees=new ArrayList<>();
    public static void main(String args[])
    {
        Employee e1=new Employee("Krishna",20,1250000);
        Employee e2=new Employee("Vaibhavi",19,1600000);
        Employee e3=new Employee("Ram",30,10000);
        Employee e4=new Employee("Avishka",17,1450000);
        Employee e5=new Employee("Jai",21,50000);
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        System.out.println("Unsorted:");
        System.out.println(employees);
        Collections.sort(employees,(emp1,emp2)->emp2.salary-emp1.salary);
        System.out.println("Descending order of Salaries:");
        System.out.println(employees);
        Collections.sort(employees,(emp1,emp2)->emp1.age-emp2.age);
        System.out.println("Ascending order of ages:");
        System.out.println(employees);
    }
}