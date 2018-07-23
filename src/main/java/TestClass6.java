import java.util.Scanner;

public class TestClass6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[]a=new int[n];
        for (int i = 0; i <n; i++) {
            a[i]=sc.nextInt();
        }
        int s=sc.nextInt();
        int e=sc.nextInt();
        boolean yes=false;
        int i=s-1;
        while(true){
            if(i==n-1){
                break;
            }else{
                i=i+a[i]-1;
                if(i==(e-1)){
                    yes=true;
                    break;
                }
            }
        }
        if(yes){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}
/*
1 ≤ N ≤ 1000
        1 ≤ Ai ≤ N
        1 ≤ S, E ≤ N*/
