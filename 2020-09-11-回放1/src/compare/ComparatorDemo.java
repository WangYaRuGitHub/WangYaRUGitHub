package compare;

import java.util.Comparator;

class ByHeightComparator implements Comparator<Teacher1>{

    @Override
    public int compare(Teacher1 o1, Teacher1 o2) {
        return o1.height - o2.height;
    }
}
class ByWeightComparator implements Comparator<Teacher1>{

    @Override
    public int compare(Teacher1 o1, Teacher1 o2) {
        return o1.weight - o2.weight;
    }
}
public class ComparatorDemo {
    public static void main(String[] args) {
        Teacher1 t1 = new Teacher1("高博",18,190,80);
        Teacher1 t2 = new Teacher1("陈沛鑫",38,170,100);

        Comparator<Teacher1> byHeight = new ByHeightComparator();
        Comparator<Teacher1> byWeight = new ByWeightComparator();
        int r;
        r = t1.compareTo(t2);//按照自然顺序去比较，即年龄
        System.out.println(r);
        //按照身高比较
        r = byHeight.compare(t1,t2);
        System.out.println(r);

        r = byWeight.compare(t1,t2);
        System.out.println(r);
    }
}
