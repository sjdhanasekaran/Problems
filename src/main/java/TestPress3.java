import java.util.Scanner;

public class TestPress3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(!(n>=1&&n<=1000)){
            System.out.println("Enter N value between 1 to 1000");
            System.exit(1);
        }
        int[] a=new int[n];
        for (int i = 0; i < a.length; i++) {
            int x=sc.nextInt();
            if((x<=1000000&&x>=1)){
                a[i]=x;
            }else {
                System.out.println("Enter the number between 1 to 1000000");
                System.exit(1);
            }
        }

        for(int i=0;i < n - 1;i++) {
            for (int j=0;j < n - i - 1;j++) {
                if (getFirstNum(a[j])< getFirstNum(a[j + 1])) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                } else if (getFirstNum(a[j])== getFirstNum(a[j + 1])) {
                    if(a[j]<a[j+1]){
                        int temp = a[j];
                        a[j] = a[j+1];
                        a[j+1] = temp;
                    }
                    }
            }
        }
        StringBuilder sr=new StringBuilder();
        for (int k = 0; k <a.length ; k++) {
            sr.append(a[k]);
        }
        System.out.println(sr.toString());
    }

    private static int getFirstNum(int n){
        char s=String.valueOf(n).charAt(0);
        return Integer.parseInt(String.valueOf(s));
    }
}
