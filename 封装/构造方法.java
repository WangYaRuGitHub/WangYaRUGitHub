package javaSE.类和对象第八节.封装;
/*public void show(){
        System.out.println("我叫" + myName + ",今年" + myAge + "岁");
        }*/
class Student1{
    private String name;
    private int age;

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student1(String name) {
        this.name = name;
    }

    public Student1(int age) {
        this.age = age;
    }

    public Student1() {
    }

    /* public Student1(){
                        System.out.println("无参数构造方法！");
                    }
                    public Student1(String name){
                        System.out.println(name);
                    }

                    public Student1(String name,int age){
                        System.out.println(name+"  "+age);
                    }
                */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
public class 构造方法 {
    public static void main(String[] args) {
        Student1 student3 = new Student1("王亚如",20);
        Student1 student2 = new Student1("毛利兰");
        System.out.println("--------------------");
        Student1 student1 = new Student1();
    }

    /*System.out.println(student1);
        student1.setName("江户川柯南");
        System.out.println(student1.getName());
        System.out.println(student1);*/
}
