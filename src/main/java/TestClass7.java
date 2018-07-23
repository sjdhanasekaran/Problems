import java.util.Scanner;

public class TestClass7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int not = sc.nextInt();
        while (not-- > 0) {
            int n = sc.nextInt();
            int sqrt = (int) Math.sqrt(n);
            int days=1,clas=1;
            int x=1;
            boolean rad=true;

            while (clas < n) {
                    if (x == sqrt) {
                        rad = false;
                    }
                    if (rad) {
                        x=(x+1);
                        clas=x+clas;
                        days += 1;
                    }
                    if (!rad) {
                        days += 1;
                        x=(x-1);
                        clas=x+clas;
                    }
                }
            System.out.println(days);
            }

    }
}