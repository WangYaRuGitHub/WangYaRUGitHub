package 瓜子二手车;

import java.util.Scanner;

public class 硬币划分 {
/*    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[]{1,2,5,10};
        System.out.println(myCount(n, 3));
    }

    private static int myCount(int n, int k) {
        int[] array = new int[]{1,2,5,10};
       if(n<0){
           return 0;
       }
       if(n == 0){
           return 1;
       }
       int count = 0;
        for (int i = 0; k>=0 && i*array[k]<=n; i++) {
            count +=myCount(n-i*array[k],k-1);
        }
        return count;
    }*/


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

/*
import java.util.Scanner;

public class 硬币划分 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[]{1,2,5,10};
        System.out.println(myCount(n, array));
    }
    public static int myCount(int n,int[] array){
        int count=0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    for (int l = 0; l <= n; l++) {
                         if (array[0]*l+ array[1]*k+array[2]*j+array[3]*i== n) {
                            count++;
                     //       System.out.println(i+" "+j+" "+ k+" "+l);
                        }
                    }
                }
            }
        }
        return count;
    }
}
*/
