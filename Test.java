import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        String c;
        int count = 0;
        for(int i = 0;i<a.length()+1;i++){
            c = a.substring(0,i)+b+a.substring(i);
            System.out.println(c);
            while(isBack(c)){
                count++;
                break;
            }
        }
        System.out.println(count);
    }

    public static boolean isBack(String c){
        for(int j = 0;j<c.length()/2;j++){
            if(c.charAt(j) != c.charAt(c.length()-j-1)){
                return false;
            }
        }
        return true;
    }
}