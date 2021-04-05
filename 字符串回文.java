package 映客2020春招;

import java.util.Scanner;

/*
给定一个字符串，判断是否回文串，只考虑字母数字字符和忽略大小写。
 */
public class 字符串回文 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(isTrue(str));
    }
    public static boolean isTrue(String str){
        str = str.toLowerCase();
        int length = str.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if(str.charAt(i) != str.charAt(length-i-1)){
                count++;
                break;
            }
        }
        if (count == 0)
            return true;
        else return false;
    }
}
