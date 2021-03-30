package 瓜子二手车;

import java.util.Scanner;

public class 单词逆序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        reverseStr(str);
    }
    public static void reverseStr(String str){
        String[] strings = str.split(" ");
        String temp = "";
        int length = strings.length;
        for (int i = 0; i < length/2; i++) {
            temp = strings[i];
            strings[i] = strings[length-1-i];
            strings[length-1-i] = temp;
        }
        for (int i = 0; i < length; i++) {
            System.out.print(strings[i]+" ");
        }
        System.out.println();
    }
}
