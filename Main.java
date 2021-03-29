package 瓜子二手车;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int coins[]= {1,2,5,10};
        int [] array=new int[100001];
        array[0]=1;
        for(int i=0;i<4;i++) {
            for(int j=coins[i];j<=n;j++) {
                array[j]=(array[j]+array[j-coins[i]])%1000000007;
            }
        }
        System.out.println(array[n]);
    }
}
