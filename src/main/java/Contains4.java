import java.util.Scanner;

public class Contains4 {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int count=0;
            for(int i=1;i<=n;i++){
                String s=String.valueOf(i);
                if(s.contains("4")){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
