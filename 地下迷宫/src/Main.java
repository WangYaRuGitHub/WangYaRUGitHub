import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 小青蛙有一天不小心落入了一个地下迷宫, 小青蛙希望用自己仅剩的体力值P跳出这个地下迷宫。
 * 为了让问题简单,假设这是一个n*m的格子迷宫,迷宫每个位置为0或者1,
 * 0代表这个位置有障碍物, 小青蛙达到不了这个位置;1代表小青蛙可以达到的位置。
 * 小青蛙初始在(0,0)位置,地下迷宫的出口在(0,m-1)
 * (保证这两个位置都是1,并且保证一定有起点到终点可达的路径),
 * 小青蛙在迷宫中水平移动一个单位距离需要消耗1点体力值,
 * 向上爬一个单位距离需要消耗3个单位的体力值,向下移动不消耗体力值,
 * 当小青蛙的体力值等于0的时候还没有到达出口,小青蛙将无法逃离迷宫。
 * 现在需要你帮助小青蛙计算出能否用仅剩的体力值跳出迷宫(即达到(0,m-1)位置)。
 * <p>
 * 输入包括n+1行：第一行为三个整数n,m（3<=m,n<=10）,p(1<=p<=100)
 * 接下来的n行:每行m个0或者1,以空格分隔
 * 输出描述：如果能逃离迷宫,则输出一行体力消耗最小的路径,输出格式见样例所示;
 * 如果不能逃离迷宫,则输出"Can not escape!"。 测试数据保证答案唯一
 * 示例1:
 * 输入
 * 4 4 10 1 0 0 1 1 1 0 1 0 1 1 1 0 0 1 1
 * 输出
 * [0,0],[1,0],[1,1],[2,1],[2,2],[2,3],[1,3],[0,3]
 */

public class Main {
    public static void main(String[] args) {
        int n,m,p;
        Scanner input=new Scanner(System.in);
        while(input.hasNextInt()) {
            n = input.nextInt();
            m = input.nextInt();
            p = input.nextInt();
            int[][] lab = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    lab[i][j] = input.nextInt();
                }
            }



            recursion(lab,n,m,p,0,0);
            if(isFind){
                System.out.println(sb.toString());
            }else{
                System.out.println("can not escape");
            }
        }
    }
    static LinkedList<LinkedList<Integer>> path=new LinkedList<LinkedList<Integer>>();
    static boolean isFind=false;
    static int maxRemainPower=0;
    static StringBuilder sb=new StringBuilder();

    public static void recursion(int[][] map,int rows,int cols,int power,int i,int j){
        if(i<0||i>=rows||j<0||j>=cols||map[i][j]==0||power<0){
            return;
        }else{
            LinkedList<Integer> tmp=new LinkedList<Integer>();
            tmp.add(i);
            tmp.add(j);
            path.add(tmp);
            map[i][j]=0;
            if(i==0&&j==cols-1){
                if(power>=maxRemainPower){
                    maxRemainPower=power;
                    updatePath(path);
                }
                isFind=true;
                map[i][j]=1;
                path.removeLast();
                return;
            }
            recursion(map,rows,cols,power-3,i-1,j);
            recursion(map,rows,cols,power-1,i,j+1);
            recursion(map,rows,cols,power,i+1,j);
            recursion(map,rows,cols,power-1,i,j-1);
            map[i][j]=1;
            path.removeLast();
        }
    }
    public static void updatePath(LinkedList<LinkedList<Integer>> list){
        Iterator<LinkedList<Integer>> iterator=list.iterator();
        while(iterator.hasNext()){
            LinkedList<Integer> tmp=iterator.next();
            sb.append("["+tmp.get(0)+","+tmp.get(1)+"]"+",");
        }
        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
