import java.util.Arrays;
import java.util.Scanner;

public class Testclass10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String l=sc.nextLine();
        String line=sc.nextLine();

        int n=Integer.parseInt(l);
        String[] split = line.split(" ");
        int[] a=new int[n];
        int sum1=0;
        for (int i = 0; i <n; i++) {
         a[i] = Integer.parseInt(split[i]);
         sum1+=a[i];
        }
        System.out.println((sum1 / n)+1);
        /*int min=0;
        Arrays.sort(a);
        for(int i=n-2;i>0;i--){
            int r=n*a[i];
            int q=n*(a[i-1]);
            if((r>sum1)&&(q<=sum1)){
                min=a[i];
                break;
            }
        }
        System.out.println(min);*/
    }
}
