import java.util.Scanner;

public class Team {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0){
            int roll=sc.nextInt();
            if(roll==1) {
                System.out.println(1);
            }else {
                System.out.println(roll/2);
            }
            t--;
        }
    }
}
