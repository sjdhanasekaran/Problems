import java.util.Scanner;

public class Surronding1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String not=sc.nextLine();
        int t=Integer.parseInt(not);
        while(t-->0){
            not=sc.nextLine();
            String s=sc.nextLine();
            String[] split = not.split("\\s+");
            String[] split1 = s.split("\\s+");
            int n=Integer.parseInt(split[0]);
            int m=Integer.parseInt(split[1]);
            int[][] a=new int[n][m];
            int r=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j]= Integer.parseInt(split1[r]);
                }
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(a[i][j]==1) {
                        boolean b = countEvenZeros(i, j, n,m,a);
                        if(b){
                            count++;
                        }
                    }
                }
            }
        }
    }
    static boolean countEvenZeros(int i,int j,int n,int m,int[][] a){
        boolean evenZeroes=true;
        int count=0;
            if(j>0){
                j--;
                if(a[i][j]==0){
                    count++;
                }
            }
            if(i>0){
            i--;
            if(a[i][j]==0){
                count++;
            }
        }



        return evenZeroes;
    }
}
