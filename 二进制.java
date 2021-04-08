package javaSE.第四节课;

import java.util.Scanner;

/*
获取一个数二进制序列中所有偶数位和奇数位，分别输出二进制序列
 */
public class 二进制 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int num = scanner.nextInt();
            for (int i = 31; i >= 0; i--) {
                System.out.print(((num >> i) & 1) + " ");
            }
            System.out.println();
        }
    }
}
