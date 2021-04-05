package 映客2020春招;

import java.util.Scanner;

public class 判断字符串是否有效 {
    public static boolean isValid (String s) {
        char[] stack = new char[s.length()];
        int point = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack[point] = c;
                point++;
            }
            if(c == ')' && stack[point-1] == '(' || c == ']' && stack[point-1] == '[' || c == '}' && stack[point-1] == '{'){
                stack[point-1] = ' ';
                point--;
            }
        }
        if(point == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(isValid(s));
    }
}
