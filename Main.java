public class Main {
    public int findKth(int[] a, int n, int K) {
        return findKthInternal(a,0,n-1,K);
    }
    public int findKthInternal(int[] a, int left, int right,int K){
        int midindex=partitiondig(a,left,right);
        if (midindex == K-1) {
            return a[midindex];
        } else if (midindex < K-1) {
            return findKthInternal(a,midindex+1,right,K);
        }
        return findKthInternal(a, 0, midindex-1,K);
    }
    private static int partitiondig(int[] num, int low, int high) {
        int tmp = num[low];
        while(low < high){
            while((low < high) && tmp >= num[high])//（1）
                high--;
            num[low] = num[high];
            while((low < high) && tmp <= num[low])//（2）
                low++;
            num[high] = num[low];
        }
        num[low] = tmp;
        return low;
    }
}