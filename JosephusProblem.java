import java.util.Scanner;

public class JosephusProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Persons : ");
        int i=sc.nextInt();
        String s = Integer.toBinaryString(i);
        String s1 = s.substring(1) +s.charAt(0);
        int output = Integer.parseInt(s1, 2);
        System.out.println(output);
    }
}
