import java.util.Scanner;

public class BeautifulMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String te = sc.nextLine();
        int t = Integer.parseInt(te);
        while (t--> 0) {
            int max=0;
            String c = sc.nextLine();
            int n = Integer.parseInt(c);
            String a = sc.nextLine();
            String[] split = a.split(" ");
            int[][] matrix = new int[n][n];
            int[] rowsum=new int[n];
            int[] columnsum=new int[n];
            int v = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(split[v]);
                    rowsum[i]+=matrix[i][j];
                    v++;
                }
                if(rowsum[i]>max){
                    max=rowsum[i];
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    columnsum[i] += matrix[j][i];
                }
                if(columnsum[i]>max){
                    max=columnsum[i];
                }
            }
            int total=0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j <n ; j++) {
                        int diff;
                        if(rowsum[i]>columnsum[i]){
                            diff=max-rowsum[i];
                        }else {
                            diff=max-columnsum[j];
                        }
                        matrix[i][j]+=diff;
                        total+=diff;
                        rowsum[i]+=diff;
                        columnsum[j]+=diff;
                    }
                }
            System.out.println(total);
        }
    }

}
