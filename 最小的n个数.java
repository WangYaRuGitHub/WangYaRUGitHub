package 瓜子二手车;

import java.util.ArrayList;

public class 最小的n个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(k>input.length){
            return list;
        }
        for(int i = 0;i<k;i++){
            for(int j = 0;j<input.length-1-i;j++){
                if(input[j]<input[j+1]){
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
            list.add(input[input.length-i-1]);
        }
        return list;
    }
}