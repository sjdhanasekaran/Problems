import java.util.Scanner;

public class LeftDivisor {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int s=sc.nextInt();
        double pow =Math.pow(n, s);
        String po = String.valueOf(String.valueOf(pow));
        for (int i = 0; i <po.length(); i++) {
            int c = Integer.parseInt(String.valueOf(po.charAt(i)));
            if(pow%c==0){
                System.out.println(c);
                break;
            }else if(i==po.length()-1){
                System.out.println(-1);
            }
        }


    }
}
