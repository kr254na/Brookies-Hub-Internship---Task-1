import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number:");
        int n=sc.nextInt();
        if(n%2==0)
            System.out.println(n+" is an Even Number");
        else
            System.out.println(n+" is an Odd Number");
    }
}