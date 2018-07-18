import java.util.Scanner;

public class Assignment {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String x=sc.nextLine();
        int t=Integer.parseInt(x);
        while(t-->0){
            x=sc.nextLine();
            int n=Integer.parseInt(x);
            int[][] a=new int[n][n];
            x=sc.nextLine();
            String[] split = x.split(" ");
            int v=0;
            for (int i = 0; i <n; i++) {
                for (int j = 0; j <n; j++) {
                    a[i][j]=Integer.parseInt(split[v]);
                    System.out.print(a[i][j]+"\t");
                    v++;
                }
                System.out.println();
            }

                        int min=a[0][1],total=0;
            for (int i = 0; i <n; i++) {
                for (int j = 1; j <n; j++) {
                    if(a[j-1][i]<min){
                        min=a[j-1][i];
                    }
                }
                total+=min;
            }
            System.out.println(total);
        }
    }
}
