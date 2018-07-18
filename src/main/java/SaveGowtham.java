import java.util.Scanner;

public class SaveGowtham {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n=sc.nextInt();
            int[] a=new int[n];
            for (int i = 0; i <n; i++) {
                a[i]=sc.nextInt();
            }
            int maximum=0;
            for (int i = 0; i <n; i++) {
                for (int k = i + 1; k < n; k++) {
                    if (a[k] > a[i]) {
                        maximum += a[k];
                        break;
                    }
                }
            }
            System.out.println(maximum);
            t--;
        }
    }
    }