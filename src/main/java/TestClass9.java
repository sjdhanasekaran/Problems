import java.util.Scanner;

public class TestClass9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String line=sc.nextLine();
        String[] split = line.split(" ");
        int a=Integer.parseInt(split[0]);

        int b =Integer.parseInt(split[1]);
        int count=0;
        for(int i=1;i<a;i++){
            if(a%i==0  && b% i==0){
                count++;
            }
        }
        System.out.println(count);
    }
}
