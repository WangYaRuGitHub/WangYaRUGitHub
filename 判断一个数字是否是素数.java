package javaSE.第三节课;

import java.util.Scanner;

public class 判断一个数字是否是素数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            int i = 2;
            for (; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    System.out.println("不是素数");
                    break;
                }
            }
            if (i > Math.sqrt(n)) {
                System.out.println("是素数");
            }
        }




       /* while(scanner.hasNext()) {
            n = scanner.nextInt();
            for (int i = 2; i <= n/2; i++) {
                if(n%i==0){
                    System.out.println("不是素数");
                    break;
                }
                if(i==n/2){
                    System.out.println("是素数");
                }
            }*/

       // }
    }
}

