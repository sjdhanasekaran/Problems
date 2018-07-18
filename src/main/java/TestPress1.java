import java.util.Scanner;

public class TestPress1 {
           public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter the the number to reversed : ");
            int num = scan.nextInt();
            if (num >= 1 && num <= 10000)
            {
               int sum=0;
                while(num>0){
                    int rem=num%10;
                    sum=(sum*10)+rem;
                    num=num/10;
                }
                System.out.println(sum);
            }
            else
            {
                System.out.println("Enter number between 1 to 10000");
            }
        }
}
